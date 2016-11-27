package oct2016.patterns.factory;

/**
 * Created by andrew on 11/27/16.
 */
public abstract class Animal {


    String name;
    int power;



    public void makeANoise() {
        System.out.println();
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void biteSome() {
        System.out.printf("%s bites and does %d damage \n", name, power);
    }

    public void introduce() {
        System.out.printf("I am %s \n", name);
    }
}
