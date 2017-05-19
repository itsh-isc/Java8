package java8.contract;

import java8.Persona;

@FunctionalInterface
public interface IPersona {
    Persona crear(int id, String nombre);
}
