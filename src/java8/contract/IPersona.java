package java8.contract;

import java8.Persona;

// en Java 8 se formaliza el concepto de interfaz funcional
// para proteger todas las clases que ya la tengan implementada
// logrando asi ESTANDARIZAR la programacion,
// de manera que si se le agregase mas de un metodo en un futuro
// el compilador marcara error justo en la interfaz, y se evitara asi
// que se agreguen nuevos metodos por descuido de algun programador
@FunctionalInterface
public interface IPersona {
    Persona crear(int id, String nombre);
    //public abstract double calcular(double n1, double n2);
    
    // Sin embargo, si pueden agregare todos los metodos por defecto que se necesiten
    public default String saludar() {
        return "Hola desde interfaz IPersona";
    }
}
