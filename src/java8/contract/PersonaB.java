/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8.contract;

/**
 *
 * @author Nekio <nekio@outlook.com>
 */
public interface PersonaB {
    default public void hablar(){
        System.out.println("Saludos desde Persona B!");
    }
}
