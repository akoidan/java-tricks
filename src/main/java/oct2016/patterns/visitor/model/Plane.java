package oct2016.patterns.visitor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import oct2016.patterns.visitor.Visitiable;
import oct2016.patterns.visitor.Visitor;

/**
 * Created by andrew on 11/28/16.
 */
@Getter
@Setter
@AllArgsConstructor
public class Plane implements Visitiable {
    private String wing;

    public boolean accept(Visitor v) {
        return v.visit(this);
    }
}
