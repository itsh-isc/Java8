package java8;

import java8.contract.Operacion;

public class _04_Alcance {
    public double probarVariableLocal(){
        final double n3 = 3.0;
        
        /*
        Operacion o = new Operacion(){
            @Override
            public double calcularPromedio(double n1, double n2) {
                //n3 = 5; //no compilaria si no estuviera declarada final
                return n1 + n2 + n3;
            }
        
        };
        */
        
        // el uso de las variables locales permanece en el concepto lambda
        // al igual que en una clase anonima:
        // pueden operarse, pero no editarse
        Operacion o = (x,y) -> {
            //n3 = 5; //no compilaria si no estuviera declarada final
            return x + y + n3;
        };
        
        return o.calcularPromedio(1, 2);
    }
    
    
    
    private static double a1;
    private double a2;
    
    public double probarVariableStatic(){
        Operacion o = (x,y) -> {
            a1 = (x+y);
            a2 = a1/2;
            
            return a2;
        };
                
        return o.calcularPromedio(3, 5);
    }
    
 
    
    public static void main(String[] args) {
        _04_Alcance test = new _04_Alcance();
        System.out.println(test.probarVariableLocal());
    }
}
