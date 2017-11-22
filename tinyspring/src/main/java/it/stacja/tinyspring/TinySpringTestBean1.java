package it.stacja.tinyspring;

@Element
public class TinySpringTestBean1 {
    public void serviceMethod() {
        System.out.println("service method from TinySpringTestBean1");
    }

    @WhenCreated
    public void init() {
        System.out.println("Created TinySpringTestBean1");
    }
}
