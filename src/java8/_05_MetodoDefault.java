package java8;

import java8.contract.PersonaA;
import java8.contract.PersonaB;

public class _05_MetodoDefault implements PersonaA{
    public static void main(String[] args) {
        _05_MetodoDefault test = new _05_MetodoDefault();
        
        test.caminar();
        test.hablar(); // se accede sin implementarlo en la clase
    }

    @Override
    public void caminar() {
        System.out.println("Hola Mundo");
    }
}

class Usando2InterfacesConMetodosDefault implements PersonaA, PersonaB{
    public static void main(String[] args) {
        Usando2InterfacesConMetodosDefault test = new Usando2InterfacesConMetodosDefault();
        test.caminar();
        test.hablar(); // como las 2 interfaces tienen la misma firma del metodo, aqui si es necesario sobreescribir para identificar cual va a usarse
    }

    /* Los metodos por defecto son una nueva funcionalidad de Java8 */
    
    @Override
    public void caminar() {
        System.out.println("Hola Mundo");
    }
    
    // como la clase implementa 2 interfaces que casualmente
    // tienen el mismo nombre del metodo default
    // debemos especificar en esta misma clase (a traves de la sobreescritura)
    // cual sera el comportamiento que va a realizar
    
    // NOTA: Es importante hacer notar, que no necesariamente debe de hacer algun llamado a super
    // y que incluso podria definir su propio comportamiento, independiente de cualquier interfaz
    // lo que resulta muy importante, si en determinado contexto, se requiriera que todas las clases
    // que implementen alguna interfaz tuvieran el comportamiento por default de esta,
    // excepto algunas en especifico
    @Override
    public void hablar() {
        PersonaB.super.hablar();
    }
    
    /* ¿Para que me sirve un metodo default de una interfaz?
    en un ambiente productivo orientado a interfaces,
    para lograr un codigo desacoplado.
    cuando se requiere que todas las clases que esten implementando 
    determinada interfaz cuenten ahora con un nuevo comportamiento,
    hay 2 opciones: 
    
    TRADICIONAL:
    Agregar el metodo abstracto en la interfaz, y sobreescribir (implementar)
    en cada clase que la implemente dicho metodo nuevo
    
    JAVA 8:
    Utilizar el metodo por defecto unicamente en la interfaz,
    y sin mas cambios, ya todas las clases que la implementan
    tendran acceso a dicho metodo nuevo, con toda la logica implementada.
    */
}