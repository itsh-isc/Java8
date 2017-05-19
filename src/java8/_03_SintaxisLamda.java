package java8;

import java8.contract.Operacion;
import java8.contract.Vacio;

public class _03_SintaxisLamda {
    private double probarSintaxis1(){
        //Operacion o = (x, y) -> (x+y)/2;
        //Operacion o = (x, y) -> {return (x+y)/2;};
        Operacion o = (x, y) -> {
            double a = 2.0;
            
            return (x+y)/a;
        };
        
        return o.calcularPromedio(4, 7);
    }
    
    private int probarSintaxis2(){
        Vacio v = () -> 3;
        
        return v.noRecibirParametros();
    }
    
    public static void main(String[] args) {
        _03_SintaxisLamda test = new _03_SintaxisLamda();
        
        System.out.println(test.probarSintaxis1());
        System.out.println(test.probarSintaxis2());
    }
}
