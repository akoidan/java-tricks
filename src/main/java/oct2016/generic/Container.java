package oct2016.generic;

import java.util.List;

/**
 * Created by andrew on 11/26/16.
 */
public class Container<P extends Product & Comparable<P>> {

    public static void main(String[] args) {
        Container<Camera> cameraContainer = new Container<>();
        cameraContainer.product = new Camera();
//        cameraContainer.product.compareTo()
    }

    <T extends Product> boolean find(List<T> all, Product t) {
        return all.contains(t);
    }

    P product;

}
