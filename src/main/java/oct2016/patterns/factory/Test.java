package oct2016.patterns.factory;

import java.util.Scanner;

/**
 * Created by andrew on 11/27/16.
 */
public class Test {
    public static void main(String[] args) {
        Animal animal = null;

        Scanner ui = new Scanner(System.in);

        System.out.println("What type of Animal? (D/C/B)");
        if (ui.hasNextLine()) {
            AnimalFactory factory = new AnimalFactory();
            String option = ui.nextLine();
            animal = factory.makeAnimal(option);
        }
        if (animal != null) {
            doStuff(animal);
        } else {
            System.out.println("D/C/B only");
        }

    }

    private static void doStuff(Animal cat) {
        cat.introduce();
        cat.biteSome();
    }
}
