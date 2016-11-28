package oct2016.patterns.visitor;

import oct2016.patterns.visitor.model.Byke;
import oct2016.patterns.visitor.model.Car;
import oct2016.patterns.visitor.model.Plane;

/**
 * Created by andrew on 11/28/16.
 */
public class LoadVisitor extends Visitor {
    @Override
    public boolean visit(Byke item) {
        return false;
    }

    @Override
    public boolean visit(Car item) {
        return false;
    }

    @Override
    public boolean visit(Plane item) {
        return false;
    }
}
