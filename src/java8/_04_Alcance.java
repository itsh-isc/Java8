package java8;

import java8.contract.Operacion;

public class _04_Alcance {
    public double probarVariableLocal(){
        double n3 = 3.0;
        
        // PROGRAMACION TRADICIONAL 
        // Definimos una clase anonima
        // con la implementacion de la interfaz Operacion
        Operacion o = new Operacion(){
            @Override
            public double calcularPromedio(double n1, double n2) {
                // La siguiente linea de codigo  no compila
                // porque las clases anonimas no pueden
                // hacer referencias a variables locales que no sean constantes
                // (es decir, que no va a cambiar su valor 
                // mientras exista en el bloque de ejecucion del metodo)
                //n3 = n1 + n2; 

                return n3;
            }
        };
        
        // PROGRAMACION USANDO LAMBDAS
        Operacion ope = (x,y) -> {
            // La siguiente linea de codigo no compila tampoco
            // dado que se implementan los mismos principios/comportamientos de
            // los ambitos (scope) de las variables dentro de una clase anonima
            //n3 = x + y;
            
            return n3;
        };
        
        return o.calcularPromedio(1, 2);
    }
    
    public double probarVariableLocalFinal(){
        final double n3 = 3.0;
        
        Operacion o = new Operacion(){
            @Override
            public double calcularPromedio(double n1, double n2) {
                //n3 = 5; //no puede reasignarse valor a una constante
                return n1 + n2 + n3;
            }
        };
        
        // el uso de las variables locales permanece en el concepto lambda
        // al igual que en una clase anonima:
        // pueden operarse, pero no editarse
        Operacion ope = (x,y) -> {
            //n3 = 5; //no puede reasignarse valor a una constante
            return x + y + n3;
        };
        
        // Tanto dentro de las funciones lambda, como dentro de las clases anonimas
        // las variables (final, o no final) del metodo contenedor pueden ser empleadas
        // pero no alteradas... esto quiere decir, que las variables del metodo contenedor
        // opcionalmente pueden ser declaradas final, pero dentro de las funciones lambda
        // y clases anonimas, siempre se comportaran como constantes
        
        return o.calcularPromedio(1, 2);
    }
    
    private static double a1;
    private double a2;
    
    public double probarVariableStatic(){
        // PROGRAMACION TRADICIONAL 
        Operacion o = new Operacion(){
            @Override
            public double calcularPromedio(double x, double y) {
                a1 = (x+y);
                a2 = a1/2;
            
            return a2;
            }
        };
        
        // PROGRAMACION USANDO LAMBDAS
        
        // Las expresiones lambda tambien tienen la capacidad de
        // lectura y escritura de los atributos estaticos y no estaticos
        // declarados en una clase
        Operacion ope = (x,y) -> {
            a1 = (x+y);
            a2 = a1/2;
            
            return a2;
        };
                
        return o.calcularPromedio(3, 5);
    }
    
 
    
    public static void main(String[] args) {
        _04_Alcance test = new _04_Alcance();
        
        System.out.println(test.probarVariableLocal());
        System.out.println(test.probarVariableLocalFinal());
        System.out.println(test.probarVariableStatic());
    }
}
