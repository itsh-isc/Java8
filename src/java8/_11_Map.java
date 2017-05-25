package java8;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class _11_Map {
    private Map<Integer, String> map;
    
    public static void main(String[] args) {
        _11_Map test = new _11_Map();
        test.poblar();
        
        //test.imprimir_v7();
        //test.imprimir_v8();
        
        //test.insertarSiAusente(5, "Ivan");
        //test.insertarSiAusente(3, "LlaveExistente"); // No sobreescribe la llave que ya existia
        //test.imprimir_v8();
        
        //test.operarSiPresente(3);
        //test.obtenerOrPredeterminado(2);
        //test.obtenerOrPredeterminado(8);
        
        test.recolectar();
    }
    
    private void poblar(){
        map = new HashMap<>();
        map.put(1,"Hola");
        map.put(2,"Mundo");
        map.put(3,"Java");
        map.put(4,"JDK");
        map.put(5,"oracle");
    }
    
    private void imprimir_v7(){
        // Antes de Java8, para recorrer un mapa
        // era necesario apoyarse del metodo entrySet
        for(Entry<Integer, String> e : map.entrySet()){
            System.out.println(e.getKey() + " - " + e.getValue());
        }
    }
    
    private void imprimir_v8(){
        // En la manera declarativa de Java8
        
        // podemos hacerlo usando una funcion lambda
        map.forEach((k,v) -> System.out.println(k + " - " + v));
        
        // o podemos hacerlo usando un metodo referenciado
        //map.entrySet().stream().forEach(System.out::println);
    }
    
    private void insertarSiAusente(int k, String v){
        // el metodo putIfAbsent, nos permite agregar un valor si no se encuentra
        map.putIfAbsent(k, v); //si solo fuera "put", sobreescribiria una llave existente
    }
    
    private void operarSiPresente(int key){
        map.computeIfPresent(key, (k,v) -> k + v ); // si existe la llave, realiza la operacion
        System.out.println(map.get(key));
    }
    
    private void obtenerOrPredeterminado(int k){
        // el metodo getOrDefault, si la llave pedida no tiene valor 
        // (es decir, no ha sido agregada en el mapa)
        // regresara el valor por defecto que se le haya definido,
        // cuqando la llave pedida si existe en el mapa, sencillamente regresa su valor asociado
        String valor = map.getOrDefault(k, "Valor por defecto");
        System.out.println(valor);
    }
    
    private void recolectar(){
        // Si queremos filtrar un conjunto de elementos de un mapa
        // y crear otro mapa a raiz de el criterio filtrado
        // podemos crear un mapa a raiz de otro, apoyados en la programacion declarativa
        
        Map<Integer, String> mapaRecolectado = map.entrySet().stream().filter( //crear mapa filtrado
            e -> e.getValue().contains("o") //por todos los elementos que contengan la letra "o" (este es el predicado)
        ).collect( //apoyados en el metodo collect 
                Collectors.toMap( // reconstruimos un nuevo mapa
                    p -> p.getKey(), p -> p.getValue() // obtenida en base a la coleccion (llave, valor) filtrada
                )
        ); 
        
        mapaRecolectado.forEach((k,v) -> System.out.println(k + " - " + v));
    }
}
