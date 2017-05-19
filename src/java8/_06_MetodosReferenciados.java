package java8;

import java.util.Arrays;
import java8.contract.IPersona;
import java8.contract.Saludo;

public class _06_MetodosReferenciados {
    public static void main(String[] args) {
        _06_MetodosReferenciados test = new _06_MetodosReferenciados();
        
        test.operar();
        
        test.referenciarMetodoInstanciaObjetoArbitrario();
        
        // Se implementa el unico método de la interfaz funcional con el método referido
        Saludo s = test::referenciarMetodoInstanciaObjetoParticular;
        s.saludar();
        
        test.referenciarConstructor();
        
        // recordar que los metodos a referencias necesitan apoyarse en una interfaz funcional
        // y que no admiten paso de parametros, debido a la currificacion
    }
    
    private void operar(){
        // 1. Usando Lambda
        //Saludo s = () -> _06_MetodosReferenciados.referenciarMetodoStatic();
        
        // 2. Usando referencia a metodos
        Saludo s = _06_MetodosReferenciados::referenciarMetodoStatic;
        s.saludar();
    }
    
    private static void referenciarMetodoStatic(){
        System.out.println("Metodo referido Static");
    }
    
    private void referenciarMetodoInstanciaObjetoArbitrario(){
        String [] nombres = {"Test", "Hola", "Mundo"};
        
        // 1. Manera tradicional
        /*Arrays.sort(nombres, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return o1.compareToIgnoreCase(o2);
            }
        });*/
        
        // 2. Usando Lambdas
        //Arrays.sort(nombres, (s1, s2) -> s1.compareToIgnoreCase(s2));
        
        // 3. Usando referencia a metodos
        // Es un metodo de instancia y no estatico
        // porque se invoca el método (compareToIgnoreCase)
        // de la instancia de la variable (nombres) que viene en el arreglo
        // el array internamente se va a recorrer elemento por elemento (lo cual ya es una instancia)
        // y en cada elemento se va a invocar el compareTo
        Arrays.sort(nombres, String::compareToIgnoreCase);
        
        
        System.out.println(Arrays.toString(nombres));
    }
    
    private void referenciarMetodoInstanciaObjetoParticular(){
        System.out.println("Metodo Referido Instancia de Objeto Particular");
    }
    
    private void referenciarConstructor(){
        // 1. Manera tradicional
        /*IPersona persona = new IPersona(){
            @Override
            public Persona crear(int id, String nombre){
                return new Persona(id, nombre);
            }
        };*/
        
        //2 . Usando Lambdas
        //IPersona persona = (id,nombre) -> (new Persona(id, nombre));
        
        // 3. Usando referencia a metodos
        IPersona persona = Persona::new;
        
        Persona p = persona.crear(1, "Ivan");
        System.out.println(p.getId() + " " + p.getNombre());
    }
}
