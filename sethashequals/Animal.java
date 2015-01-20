/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sethashequals;

import java.util.Objects;

/**
 *
 * @author andrew
 */
public class Animal {
    
    public String animal;
    
    public void printAnimal (){
        System.out.println(animal);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Animal)) {
            return false;
        }
//        if (obj.getClass() != this.getClass()) {
//            return false;
//        }
        
        final Animal other = (Animal) obj;
        if (!Objects.equals(this.animal, other.animal)) {
            return false;
        }
        return true;
    }
    
    
}
