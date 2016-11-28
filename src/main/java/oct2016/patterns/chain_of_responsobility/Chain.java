package oct2016.patterns.chain_of_responsobility;

/**
 * Created by andrew on 11/28/16.
 */
public abstract class Chain {

    protected Chain nextChain;

    Chain setNextChain(Chain next) {
        this.nextChain = next;
        return next;
    }

    abstract void calculate(Request request);
}
