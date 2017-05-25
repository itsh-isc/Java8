package java8;

// Crear anotaciones sirve para customizar nuestro codigo
// y crear metadatos (los dato de los datos)
public class _12_Anotaciones {
    public @interface Lenguaje{
        String value();
    }

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
        // El API Reflection de Java permite tener operaciones de manipulacion con un objeto de una clase
        // Esta API al basarse en las clases, requiere la propiedad '.class' de las mismas
        
        Lenguaje[] lenguaje = LenguajeProgramacion.class.getAnnotationsByType(Lenguaje.class);
        
        int cantidadLenguajes = lenguaje.length;
        System.out.println("Se encontraron " + cantidadLenguajes + " Lenguajes");
        for(int i = 0; i < cantidadLenguajes; i++){
            System.out.println(lenguaje[i].value());
        }
        
        // Por defecto el scope (alcance) de la retencion de las anotaciones es class
        // y en tiempo de ejecucion (RUNTIME) no son alcanzadas
    }
}
