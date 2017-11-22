package it.stacja.tinyspring;

import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TinySpringContext {
    private final Map<Class, Object> instances = new HashMap<>();
    private final String prefix;

    public TinySpringContext(String prefix) {
        this.prefix = prefix;
        init();
    }

    private void init() {
        Reflections reflections = new Reflections(this.prefix);
        Set<Class<?>> elements = reflections.getTypesAnnotatedWith(Element.class);

        elements.stream().filter(aClass -> !aClass.isAnnotationPresent(Lazy.class)).forEach(this::resolve);
    }

    private Object resolve(Class<?> elementClass) {
        if(!elementClass.isAnnotationPresent(Element.class)) {
            throw new IllegalArgumentException("Only classes marked with Element are supported!");
        }

        if(this.instances.containsKey(elementClass)) {
            return this.instances.get(elementClass);
        }

        Constructor<?>[] constructors = elementClass.getConstructors();
        if(constructors.length > 1) {
            throw new IllegalArgumentException("Too many constructors!");
        }

        Constructor<?> primaryConstructor = constructors[0];
        Class<?>[] parameterTypes = primaryConstructor.getParameterTypes();
        Object[] parameterValues = Arrays.stream(parameterTypes).map(this::resolve).toArray();

        try {
            Object newInstance = primaryConstructor.newInstance(parameterValues);

            ReflectionUtils.getMethods(elementClass, input -> input.isAnnotationPresent(WhenCreated.class)).forEach(method -> {
                try {
                    method.invoke(newInstance);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

            if(!elementClass.isAnnotationPresent(Proto.class)) {
                this.instances.put(elementClass, newInstance);
            }

            return newInstance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T getElement(Class<T> t) {
        return (T) this.resolve(t);
    }
}
