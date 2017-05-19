package java8;

import java.util.Optional;

public class _09_Optional {
    public static void main(String[] args) {
        _09_Optional test = new _09_Optional();
        
        //Optional dispone de muchos metodos para gestionar los NullPointerException
        //No se recomienda para aplicaciones criticas en rendimiento, ya que esta clase es costosa
        
        //test.probarTradicional(null); //NullPointerException
        //test.probarOptional(null); //NoSuchElementException
        //test.optionalOf(null); //NullPointerException
        //test.orElse(null); //Valor por defecto
        test.orElseThrow(null); //Lanza una exepcion elegida por nosotros
        //test.isPresent(null); //define booleano si hay o no hay valor
        
        System.out.println("fin");
    }
    
    private void probarTradicional(String valor){
        System.out.println(valor.contains("Java"));
    }
    
    private void probarOptional(String valor){
        try {
            Optional o = Optional.empty();
            Object objeto = o.get();
        } catch (Exception e) {
                System.out.println("No hay elemento:" + e);
        }
    }
    
    private void optionalOf(String valor){
        Optional<String> o = Optional.of(valor);
        String x = o.get();
        
        System.out.println(x);
    }
    
    private void orElse(String valor){
        Optional<String> o = Optional.ofNullable(valor);
        String x = o.orElse("Predeterminado");
        
        System.out.println(x);
    }
    
    private void orElseThrow(String valor){
        Optional<String> o = Optional.ofNullable(valor);
        String x = o.orElseThrow(MiExcepcion::new);
        
        System.out.println(x); //<---- No es alcanzada esta linea
    }
    
    private void isPresent(String valor){
        Optional<String> o = Optional.ofNullable(valor);
        boolean initialized = o.isPresent();
        
        System.out.println(initialized);
    }
}

class MiExcepcion extends RuntimeException{
    public MiExcepcion(){
        super("Mi Excepcion...");
    }
}