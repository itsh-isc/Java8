package java8;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class _12_Anotaciones_Repeticion_JDK8 {
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Lenguajes{
        Lenguaje[] value()default{};
    }
    
    // Si se comenta la anotacion Repeatable, habra un error de compilacion en la interfaz
    @Repeatable(value = Lenguajes.class)
    public @interface Lenguaje{
        String value();
    }
    
    // JDK 1.8
    // Simplemente indicamos las anotaciones que deseamos repetir
    // sin necesidad de anidar anotaciones en la cabecera de la  interfaz
    @Lenguaje("Java")
    @Lenguaje("Python")
    public interface LenguajeProgramacion{}
    
    public static void main(String[] args) {
        Lenguaje[] lenguajes = LenguajeProgramacion.class.getAnnotationsByType(Lenguaje.class);
        
        int cantidadLenguajes = lenguajes.length;
        System.out.println("Se encontraron " + cantidadLenguajes + " Lenguajes");
        
        Lenguajes len2 = LenguajeProgramacion.class.getAnnotation(Lenguajes.class);
        for(Lenguaje lenguaje: len2.value()){
            System.out.println(lenguaje);
        }
    }
}
