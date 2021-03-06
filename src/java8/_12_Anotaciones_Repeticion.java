package java8;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class _12_Anotaciones_Repeticion {
    // la anotacion Repeatable permite anotaciones repetidas en una clase
    // definiendo cual sera, en el argumento 'value'
    @Repeatable(value = Lenguajes.class)
    public @interface Lenguaje{
        String value();
    }
    
    // la anotacion Retention define el tipo de retencion RUNTIME
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Lenguajes{
        Lenguaje[] value()default{};
    }
    
    // JDK 1.7
    @Lenguajes({
        @Lenguaje("Java"),
        @Lenguaje("Python")
    })
    public interface LenguajeProgramacion{}
    
    public static void main(String[] args) {        
        Lenguaje[] lenguaje = LenguajeProgramacion.class.getAnnotationsByType(Lenguaje.class);
        
        int cantidadLenguajes = lenguaje.length;
        System.out.println("Se encontraron " + cantidadLenguajes + " Lenguajes");
        for(int i = 0; i < cantidadLenguajes; i++){
            System.out.println(lenguaje[i].value());
        }
    }
}
