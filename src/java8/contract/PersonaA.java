package java8.contract;

public interface PersonaA {
    public abstract void caminar();
    
    // Metodo por defecto
    // Es un metodo IMPLEMENTADO en una interfaz
    // para que cualquier clase que la implemente
    // ya tenga acceso al metodo definido
    default public void hablar(){
        System.out.println("Saludos desde INTERFAZ Persona A!");
    }
}
