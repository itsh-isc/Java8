package java8.contract;

// Interfaz funcional
// (El concepto existia desde antes de Java 8,
// pero no de manera formal... por ejemplo, revisar la interfaz Comparable)
public interface Operacion {
    // Define una unica operacion (un solo metodo)
    public abstract double calcularPromedio(double n1, double n2);
    
    // Si se tiene mas de 1 metodo en la interfaz, deja de ser considerada funcional
    // y por lo tanto, no puede emplearse en funciones lambda.
    
    // NOTA: Es importante resaltar que no existira problema para compilar la interfaz
    // pero si habra problemas de compilacion en todas las clases que hayan ocupado a esta interfaz
    //public abstract double calcular(double n1, double n2);
}
