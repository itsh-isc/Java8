package java8;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class _12_Anotaciones_Repeticion_JDK8 {
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Lenguajes{
        Lenguaje[] value()default{};
    }
    
    @Repeatable(value = Lenguajes.class)
    public @interface Lenguaje{
        String value();
    }
    
    // JDK 1.8
    @Lenguaje("Java")
    @Lenguaje("Python")
    public interface LenguajeProgramacion{}
    
    public static void main(String[] args) {
        Lenguajes l = LenguajeProgramacion.class.getAnnotation(Lenguajes.class);
        for(Lenguaje lenguaje: l.value()){
            System.out.println(lenguaje);
        }
    }
}
