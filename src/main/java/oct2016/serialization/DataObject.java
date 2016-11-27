package oct2016.serialization;

import java.io.Serializable;

/**
 * Created by andrew on 11/26/16.
 */
public class DataObject extends DataSuper implements Serializable{
    public String a;

    public DataObject(String a) {
        this.a = a;
    }
}
