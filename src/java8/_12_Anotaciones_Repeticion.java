package java8;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class _12_Anotaciones_Repeticion {
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Lenguajes{
        Lenguaje[] value()default{};
    }
    
    @Repeatable(value = Lenguajes.class)
    public @interface Lenguaje{
        String value();
    }
    
    // JDK 1.7
    @Lenguajes({
        @Lenguaje("Java"),
        @Lenguaje("Python")
    })
    public interface LenguajeProgramacion{}
    
    public static void main(String[] args) {
        Lenguaje[] lenguaje = LenguajeProgramacion.class.getAnnotationsByType(Lenguaje.class);
        for(int i=0; i<lenguaje.length; i++){
            System.out.println(lenguaje[i].value());
        }
    }
}
