package java8.contract;

public interface PersonaA {
    public abstract void caminar();
    
    default public void hablar(){
        System.out.println("Saludos desde Persona A!");
    }
}
