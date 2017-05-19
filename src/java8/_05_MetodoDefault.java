package java8;

import java8.contract.PersonaA;
import java8.contract.PersonaB;

public class _05_MetodoDefault implements PersonaA{
    public static void main(String[] args) {
        _05_MetodoDefault test = new _05_MetodoDefault();
        test.caminar();
        test.hablar(); // se accede sin implementarlo
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

    @Override
    public void caminar() {
        System.out.println("Hola Mundo");
    }
    
    @Override
    public void hablar() {
        PersonaB.super.hablar();
    }
}