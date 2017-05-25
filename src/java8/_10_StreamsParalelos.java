package java8;

import java.util.ArrayList;
import java.util.List;

public class _10_StreamsParalelos {
    private List<Integer> numeros;
    
    public static void main(String[] args) {
        _10_StreamsParalelos test = new _10_StreamsParalelos();
        
        test.llenar();
        test.probarStreamSecuencial();
        test.probarStreamParalelo();
        
        // Puede mejorar el rendimiento en algunas aplicaciones
        // Pero en Java EE Container no es aconsejable
        // (por ejemplo, servidores de aplicaciones que interactuen con JPA, EJB, etc.)
        // pues puede saturar las peticiones de un ambiente asincrono
        
        // Se recomienda en aplicaciones de escritorio o de tipo batch (consola)
    }
    
    private void llenar(){
        numeros = new ArrayList<>();
        for(int i=0; i<10; i++){
            numeros.add(i);
        }
    }
    
    private void probarStreamSecuencial(){
        System.out.println("--------SECUENCIAL----------");
        numeros.stream().forEach(System.out::println);
    }
    
    private void probarStreamParalelo(){
        System.out.println("--------PARALELO----------");
        
        // procesamiento asincrono, empleando hilos
        // cada ejecucion resulta aleatoria
        // por lo que su comportamiento varia
        numeros.parallelStream().forEach(System.out::println);
    }
}
