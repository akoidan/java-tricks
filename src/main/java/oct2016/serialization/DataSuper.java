package oct2016.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by andrew on 11/26/16.
 */
public class DataSuper implements Serializable {
    private int lol;


    private void writeObject(ObjectOutputStream oos) throws IOException, ClassNotFoundException {
            oos.defaultWriteObject();
            oos.writeObject(this.lol);
    }

    private void readObject(ObjectInputStream oos) throws IOException,ClassNotFoundException {

    }

    public int getKOKO() {
        return this.lol;
    }

    public void setLol(int lol) {
        this.lol = lol;
    }
}
