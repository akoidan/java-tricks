package oct2016.patterns.factory;

/**
 * Created by andrew on 11/27/16.
 */
public class AnimalFactory {

    public Animal makeAnimal(String type) {
        Animal animal = null;
        if (type.equals("D")) {
            animal= new Dog();
        } else if (type.equals("C")) {
            animal = new Cat();
        } else if (type.equals("B")) {
            animal = new BigDog();
        }
        return animal;
    }
}
