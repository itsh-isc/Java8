/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Nekio <nekio@outlook.com>
 */
public class _07_Listas {
    private List<String> lista;
    
    public static void main(String[] args) {
        _07_Listas test = new _07_Listas();
        test.llenarLista();
        //test.usarSort();
        //test.usarRemoveIf();
        test.usarForEach();
    }
    
    private void llenarLista(){
        lista = new ArrayList<String>();
        
        lista.add("Mundo");
        lista.add("HolaMundo");
        lista.add("Hola");
    }
    
    private void usarForEach(){
        // 1. Manera tradicional
        /*
        for(String elemento: lista){
            System.out.println(elemento);
        }*/
        
        // 2. usando Lambdas
        //lista.forEach(elemento -> System.out.println(elemento));
        
        // 3. Usando Metodo referenciado
        lista.forEach(System.out::println);
    }
    
    private void usarRemoveIf(){
        // 1. Manera tradicional
        /*
        // Recordemos que no se podria hacer de esta manera,
        // pues mandaria una exepcion de concurrencia
        for(String elemento: lista){
            if(elemento.equalsIgnoreCase("Hola"){
                lista.remove(elemento);
            }
        }
        
        // necesita un iterador
        Iterator<String> it = lista.iterator();
        while(it.hasNext()){
            if(it.next().equalsIgnoreCase("Hola")){
                it.remove();
            }
        }
        */
        
        // 2. usando Lambdas
        lista.removeIf(elemento -> elemento.equalsIgnoreCase("Hola"));
    }
    
    private void usarSort(){
        lista.sort((x,y) -> x.compareTo(y));
    }
}
