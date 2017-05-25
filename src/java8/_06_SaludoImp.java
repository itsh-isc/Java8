package java8;

import java8.contract.Saludo;

/**
 *
 * @author Nekio <nekio@outlook.com>
 */
public class _06_SaludoImp implements Saludo{
    @Override
    public void saludar() {
        System.out.println("Saludando desde una clase que implementa la interfaz Saludo");
    }
}
