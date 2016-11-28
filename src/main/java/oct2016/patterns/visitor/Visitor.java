package oct2016.patterns.visitor;

import oct2016.patterns.visitor.model.*;

/**
 * Created by andrew on 11/28/16.
 */
public abstract class Visitor {
    public abstract boolean visit(Byke item);
    public abstract boolean visit(Car item);
    public abstract boolean visit(Plane item);

}
