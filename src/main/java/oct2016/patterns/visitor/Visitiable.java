package oct2016.patterns.visitor;

/**
 * Created by andrew on 11/28/16.
 */
public interface Visitiable {
    boolean accept(Visitor visitor);
}
