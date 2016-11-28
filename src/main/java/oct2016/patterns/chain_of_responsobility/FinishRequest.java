package oct2016.patterns.chain_of_responsobility;

/**
 * Created by andrew on 11/28/16.
 */
public class FinishRequest extends Chain {
    @Override
    void calculate(Request request) {
        throw new RuntimeException("No such method "+  request.getCalculationWanted());
    }
}
