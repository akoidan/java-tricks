package oct2016.patterns.chain_of_responsobility;

/**
 * Created by andrew on 11/28/16.
 */
public class MultNumber extends Chain {
    @Override
    void calculate(Request request) {
        if ('*' == request.getCalculationWanted()) {
            System.out.println(request.getN1() + request.getN2());
        } else {
            nextChain.calculate(request);
        }
    }
}
