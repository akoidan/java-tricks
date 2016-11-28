package oct2016.patterns.chain_of_responsobility;

import java.util.Scanner;

/**
 * Created by andrew on 11/28/16.
 */
public class Main {

    public static void main(String[] args) {
        AddNumber startRequest = new AddNumber();
        startRequest
                .setNextChain(new SubNumbers())
                .setNextChain(new DivNumber())
                .setNextChain(new MultNumber())
                .setNextChain(new FinishRequest());
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter first arg");
        int a = reader.nextInt();
        System.out.println("Enter operation: +-*/");
        char c = reader.next(".").charAt(0);
        System.out.println("Enter second arg");
        int b = reader.nextInt();

        startRequest.calculate(new Request(a, b, c));
    }
}
