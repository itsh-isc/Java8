package java8;

import java.util.ArrayList;
import java.util.List;

public class _08_StreamsSecuenciales {
    private List<String> lista;
    private List<String> numeros;
    
    public _08_StreamsSecuenciales(){
        lista = new ArrayList<>();
        lista.add("Java");
        lista.add("Oracle");
        lista.add("JDK 1.8");
        lista.add("HolaMundo");
        
        numeros = new ArrayList<>();
        numeros.add("1");
        numeros.add("2");
        numeros.add("3");
        numeros.add("4");
    }
    
    public static void main(String[] args) {
        _08_StreamsSecuenciales test = new _08_StreamsSecuenciales();
        
        //test.filtrar();
        //test.ordenar();
        //test.transformar();
        //test.transformarNumeros();
        test.limitar();
        test.contar();
    }
    
    private void filtrar(){
        //Filtramos todas las cadenas que empiezan con J y las imprimimos
        
        // 1. Usando Lambda
        //lista.stream().filter(x -> x.startsWith("J")).forEach(x -> System.out.println(x));
        
        //2. Usando metodo de referencia
        lista.stream().filter(x -> x.startsWith("J")).forEach(System.out::println);
    }
    
    private void ordenar(){
        // Ascendente
        //lista.stream().sorted().forEach(System.out::println);
        
        // Descendente
        lista.stream().sorted(((x,y) -> y.compareTo(x))).forEach(System.out::println);
    }
    
    private void transformar(){
        // La funcion Map transforma los elementos de la coleccion 
        // a traves de la expresion indicada como parametro
        lista.stream().map(String::toUpperCase).forEach(System.out::println);
    }
    
    private void transformarNumeros(){
        // La funcion Map transforma los elementos de la coleccion 
        // a traves de la expresion indicada como parametro

        // 1. Manera Tradicional
        /*
        for(String n: numeros){
            int num = Integer.parseInt(n) + 1;
            System.out.println(num);
        }*/
        
        // 2. Usando Lambdas
        numeros.stream().map(x -> Integer.parseInt(x) + 1).forEach(System.out::println);
    }
    
    private void limitar(){
        lista.stream().limit(2).forEach(System.out::println);
    }
    
    private void contar(){
        long contador = lista.stream().count();
        System.out.println(contador);
    }
}
