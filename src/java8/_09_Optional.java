package java8;

import java.util.Optional;

public class _09_Optional {
    // Java 8 pretende reducir la cantidad de NullPointerException
    public static void main(String[] args) {
        _09_Optional test = new _09_Optional();
        
        //Optional dispone de muchos metodos para gestionar los NullPointerException
        //No se recomienda para aplicaciones criticas en rendimiento, ya que esta clase es costosa
        
        test.probarTradicional(null); //NullPointerException
        //test.probarOptional(null); //NoSuchElementException
        //test.optionalOf(null); //NullPointerException
        //test.orElse(null); //Valor por defecto
        //test.orElseThrow(null); //Lanza una exepcion elegida por nosotros
        //test.isPresent(null); //define booleano si hay o no hay valor
        
        System.out.println("fin");
    }
    
    private void probarTradicional(String valor){
        // Cuando el parametro sea nulo, se lanza NullPointerException
        System.out.println(valor.contains("Java"));
    }
    
    private void probarOptional(String valor){
        try {
            // Esta es una clase envoltorio (wrapper)
            Optional o = Optional.empty();
            Object objeto = o.get(); // el metodo get retorna el tipo de dato generico del Optional
        } catch (Exception e) {
                System.out.println("No hay elemento:" + e);
        }
    }
    
    private void optionalOf(String valor){
        // el metodo of recibe algun valor en el Optional, siempre y cuando no sea nulo
        Optional<String> o = Optional.of(valor);
        String x = o.get();
        
        System.out.println(x);
    }
    
    private void orElse(String valor){
        // ofNullable permitira valores nulos en el Optional
        Optional<String> o = Optional.ofNullable(valor);
        //  El metodo orElse retorna un valor por defecto cuando el optional contiene un nulo
        String x = o.orElse("Predeterminado");
        
        System.out.println(x);
    }
    
    private void orElseThrow(String valor){
        Optional<String> o = Optional.ofNullable(valor);
        
        // el metodo orElseThrow funciona similar al metodo orElse
        // pero permite lanzar una excepcion personalizada
        String x = o.orElseThrow(MiExcepcion::new);
        
        System.out.println(x); //<---- No es alcanzada esta linea
    }
    
    private void isPresent(String valor){
        Optional<String> o = Optional.ofNullable(valor);
        
        // el metodo isPresent devuelve true si Optional contiene un valor no nulo
        boolean initialized = o.isPresent();
        
        System.out.println(initialized);
    }
}

// Exepcion codificada por nosotros
class MiExcepcion extends RuntimeException{
    public MiExcepcion(){
        super("Mi Excepcion...");
    }
}