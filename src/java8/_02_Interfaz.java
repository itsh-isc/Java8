package java8;

import java8.contract.Operacion;

public class _02_Interfaz {
    public static void main(String[] args) {
        /* Imperativamente se necesita crear un objeto anonimo 
            que se instancie a traves de
            implementar el contrato de una interfaz,
            para poder manipularlo en una referencia
        */
        Operacion o = new Operacion(){
            @Override
            public double calcularPromedio(double n1, double n2){
                return (n1+n2)/2;
            }
        };
        
        System.out.println(o.calcularPromedio(5, 10));
        
        /* Declarativamente puede usarse Lambda en todo lugar donde
            pudiera usarse una clase anonima
        (el JDK puede obviar los tipos de dato en los parametros, y pueden omitirse)
        */
        Operacion o2 = (x, y) -> (x+y)/2;        
        System.out.println(o2.calcularPromedio(4, 7));
        
        // Existe una reduccion considerable de codigo,
        // al basarse sobre el enfoque de la programacion declarativa
    }
}
