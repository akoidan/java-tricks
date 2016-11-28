package oct2016.patterns.visitor;

import oct2016.patterns.visitor.model.Byke;
import oct2016.patterns.visitor.model.Car;
import oct2016.patterns.visitor.model.Plane;

/**
 * Created by andrew on 11/28/16.
 */
public class SaveVisitor extends Visitor {
    @Override
    public boolean visit(Byke item) {
        System.out.printf("Saving seat %s for byke \n", item.getSeat());
        return false;
    }

    @Override
    public boolean visit(Car item) {
        System.out.printf("Saving trunk %s for car \n", item.getTrunk());
        return false;
    }

    @Override
    public boolean visit(Plane item) {
        System.out.printf("Saving wing %s for plane \n", item.getWing());
        return false;
    }
}
