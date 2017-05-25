package java8;

import java8.contract.Operacion;
import java8.contract.Vacio;

public class _03_SintaxisLamda {
    private double probarSintaxis1(){
        // El fin de una expresion lambda es
        // poder tener un codigo mas legible
        
        //
        // SINTAXIS LAMBDA TRADICIONAL
        //
        Operacion o = (x, y) -> (x+y)/2;
        
        //
        // SINTAXIS LAMBDA MAS ELABORADAS
        // Se recomienda evitarlas, de ser posible
        // Pero se realizan a continuacion con fines demostrativos
        //
        
        // La simple operacion anterior tambien podria realizarse
        // en un bloque de codigo que use la sentencia return
        // (aunque una sola linea de codigo entre llaves no parezca muy amigable visualmente)
        //Operacion o = (double x, double y) -> {return (x + y)/2;};
        
        // Se le ve mas sentido de orden cuando existen bloques de codigo
        // de varias lineas
        
        // NOTA: Poner atencion que en el ejemplo anterior, los parametros estan tipados
        // y a continuacion se definen las variables (x,y) sin tipado
        // Esto es por que la JVM es capaz de interpretarlas en tiempo de ejecucion
        /*Operacion o = (x, y) -> {
            double a = 2.0;
            
            return (x+y)/a;
        };*/
        
        return o.calcularPromedio(4, 7);
    }
    
    private int probarSintaxis2(){
        // La sintaxis lambda para no recibir parametros
        // consta de sencillamente dejar parentesis vacios
        // en la parte izquierda de la expresion
        Vacio v = () -> 3;
        
        return v.noRecibirParametros();
    }
    
    public static void main(String[] args) {
        _03_SintaxisLamda test = new _03_SintaxisLamda();
        
        System.out.println(test.probarSintaxis1());
        System.out.println(test.probarSintaxis2());
    }
}
