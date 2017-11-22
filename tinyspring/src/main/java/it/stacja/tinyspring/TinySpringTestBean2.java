package it.stacja.tinyspring;

@Element
public class TinySpringTestBean2 {

    private final TinySpringTestBean1 tinySpringTestBean1;

    public TinySpringTestBean2(TinySpringTestBean1 tinySpringTestBean1) {
        this.tinySpringTestBean1 = tinySpringTestBean1;
    }

    public void serviceMethod() {
        System.out.println("service method from TinySpringTestBean2");
        this.tinySpringTestBean1.serviceMethod();
    }
}
