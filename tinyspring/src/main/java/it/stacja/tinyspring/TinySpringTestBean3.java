package it.stacja.tinyspring;

@Element
@Proto
public class TinySpringTestBean3 {
    public void serviceMethod() {
        System.out.println("service method from TinySpringTestBean3");
    }

    @WhenCreated
    public void init() {
        System.out.println("Created TinySpringTestBean3");
    }
}
