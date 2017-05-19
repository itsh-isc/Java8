package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class _14_FuncionesDeAltoOrden {
    private Function<String, String> convertirMayusculas;
    private Function<String, String> convertirMinusculas;
    
    public _14_FuncionesDeAltoOrden(){
        convertirMayusculas = x -> x.toUpperCase();
        convertirMinusculas = x -> x.toLowerCase();
    }
    
    private void probar(){
        String texto = "Hola Mundo Java con JDK8";
        
        imprimir(convertirMayusculas, texto);
        imprimir(convertirMinusculas, texto);
    }
    
    private void imprimir(Function<String, String> funcion, String valor){
        System.out.println(funcion.apply(valor));
    }
    
    private Function<String, String> mostrar(String mensaje){
        return (String x) -> mensaje + x;
    }
    
    private void filtrar(List<String> lista, Consumer<String> consumidor, int longitud){
        lista.stream().filter(this.establecerLogicaFiltro(longitud)).forEach(consumidor);
    }
    
    private void filtrar(List<String> lista, Consumer<String> consumidor, String cadena){
        lista.stream().filter(this.establecerLogicaFiltro(cadena)).forEach(consumidor);
    }
    
    private Predicate<String> establecerLogicaFiltro(int longitud){
        return texto -> texto.length() < longitud;
    }
    
    private Predicate<String> establecerLogicaFiltro(String filtro){
        return texto -> texto.contains(filtro);
    }
    
    public static void main(String[] args) {
        _14_FuncionesDeAltoOrden test = new _14_FuncionesDeAltoOrden();
        test.probar();
        
        String x = test.mostrar("Hey").apply("You");
        System.out.println(x);
        
        // Filtrado de listas
        List<String> lista = new ArrayList<String>();
        
        lista.add("HolaMundo");
        lista.add("Hola");
        lista.add("Mundo");
        lista.add("Test");
        lista.add("Java");
        lista.add("Oracle");
        
        System.out.println("\nLongitud menor a 6");
        test.filtrar(lista, System.out::println, 6);
        
        System.out.println("\nCadenas que incluyen la letra o");
        test.filtrar(lista, System.out::println, "o");
    }
}
