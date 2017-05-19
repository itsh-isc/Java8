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
        for(Entry<Integer, String> e : map.entrySet()){
            System.out.println(e.getKey() + " - " + e.getValue());
        }
    }
    
    private void imprimir_v8(){
        //map.forEach((k,v) -> System.out.println(k + " - " + v));
        map.entrySet().stream().forEach(System.out::println);
    }
    
    private void insertarSiAusente(int k, String v){
        map.putIfAbsent(k, v); //si solo fuera "put", sobreescribiria una llave existente
    }
    
    private void operarSiPresente(int key){
        map.computeIfPresent(key, (k,v) -> k+v ); // si existe la llave, realiza la operacion
        System.out.println(map.get(key));
    }
    
    private void obtenerOrPredeterminado(int k){
        String valor = map.getOrDefault(k, "Valor por defecto");
        System.out.println(valor);
    }
    
    private void recolectar(){
        // Crear un mapa a raiz de otro
        
        Map<Integer, String> mapaRecolectado = map.entrySet().stream().filter( //crear mapa filtrado
            e -> e.getValue().contains("o") //por los elementos que contengan la letra "o"
        ).collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue())); //apoyados en el metodo collect para armar el nuevo mapa en base a la coleccion filtrada
        
        mapaRecolectado.forEach((k,v) -> System.out.println(k + " - " + v));
    }
}
