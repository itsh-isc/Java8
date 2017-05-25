package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

// Programacion de Alto Orden, enfocada al paso o devolucion de funciones en el codigo
public class _14_FuncionesDeAltoOrden {
    //Los tipos genericos de la interfaz Function se corresponden con
    // T: Tipo de entrada
    // R: Retorno
    private Function<String, String> convertirMayusculas;
    private Function<String, String> convertirMinusculas;
    
    public _14_FuncionesDeAltoOrden(){
        convertirMayusculas = x -> x.toUpperCase();
        convertirMinusculas = x -> x.toLowerCase();
    }
    
    public static void main(String[] args) {
        _14_FuncionesDeAltoOrden test = new _14_FuncionesDeAltoOrden();
        test.probar();
        
        /*String x = test.mostrar("Hey").apply("You");
        System.out.println(x);*/
        
        // Filtrado de listas
        /*List<String> lista = new ArrayList<String>();
        
        lista.add("HolaMundo");
        lista.add("Hola");
        lista.add("Mundo");
        lista.add("Test");
        lista.add("Java");
        lista.add("Oracle");
        
        System.out.println("\nLongitud menor a 6");
        test.filtrar(lista, System.out::println, 6);
        
        System.out.println("\nCadenas que incluyen la letra o");
        test.filtrar(lista, System.out::println, "o");*/
    }
    
    private void probar(){
        String texto = "Hola Mundo Java con JDK8";
        
        imprimir(convertirMayusculas, texto);
        imprimir(convertirMinusculas, texto);
    }
    
    private void imprimir(Function<String, String> funcion, String valor){
        // imprimir el resultado de la funcion pasada por parametro
        // el metodo apply devuelve el tipo de dato definido como salida en el generico de la funcion
        // y el parametro que reciba, sera del tipo de entrada definido en el generico de la funcion
        System.out.println(funcion.apply(valor));
    }
    
    private Function<String, String> mostrar(String mensaje){
        // concatena el mensaje recibido por parametro y lo devuelve en el return
        return (String x) -> mensaje + x;
    }
    
    private void filtrar(List<String> lista, Consumer<String> consumidor, int longitud){
        // Vamos a pasar un criterio de filtro
        // y en base a ello imprmir resultados
        lista.stream().filter(
                this.establecerLogicaFiltro(longitud) // Predicado customizado
        ).forEach(consumidor); // aplica el metodo consumidor definido en cada iteracion de la lista
    }
    
    private void filtrar(List<String> lista, Consumer<String> consumidor, String cadena){
        lista.stream().filter(this.establecerLogicaFiltro(cadena)).forEach(consumidor);
    }
    
    /*2 Predicados con diferentes criterios de filtrado */
    private Predicate<String> establecerLogicaFiltro(int longitud){
        // regresar solo los elementos que tengan una longitud menor a la pasada por parametro
        return texto -> texto.length() < longitud;
    }
    
    private Predicate<String> establecerLogicaFiltro(String filtro){
        // regresar solo los elementos que contengan el texto pasado por parametro
        return texto -> texto.contains(filtro);
    }
}
