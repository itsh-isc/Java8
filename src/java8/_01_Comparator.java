package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _01_Comparator {
    public static void main(String[] args) {
        _01_Comparator test = new _01_Comparator();
        
        test.ordenarImperativo();
        test.ordenarDeclarativo();
    }
    
    // Linea por linea hay que decirle todo lo que debe de hacer
    // (Codigo verboso)
    private void ordenarImperativo(){
        System.out.println("Usando Paradigma Imperativo");
        List<String> lista = new ArrayList<String>();
        lista.add("Hola");
        lista.add("Mundo");
        lista.add("Java 8");
        
        Collections.sort(lista, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return o1.compareTo(o2);
            }
        });
        
        for(String texto : lista){
            System.out.println(texto);
        }
    }
    
    private void ordenarDeclarativo(){
        System.out.println("Usando Paradigma Declarativo");
        List<String> lista = new ArrayList<String>();
        lista.add("Hola");
        lista.add("Mundo");
        lista.add("Java 8");
        
        Collections.sort(lista, (String p1, String p2) -> p1.compareTo(p2));
        
        for(String texto : lista){
            System.out.println(texto);
        }
    }
}
