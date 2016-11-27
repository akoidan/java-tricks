package oct2016.serialization;

import java.io.*;

/**
 * Created by andrew on 11/26/16.
 */
public class Main {
    public static final String TMP_FILE = "/tmp/lol.bin";

    public static void main(String[] args) throws Exception {
        writeData("KOKOKO", 10);

        DataObject d = (DataObject) readData();
        System.out.printf("String: %s, Int %d", d.a, d.getKOKO());
    }

    private static Object readData() throws IOException, ClassNotFoundException {
        File f = new File(TMP_FILE);
        FileInputStream fos = new FileInputStream(f);
        ObjectInputStream oso = new ObjectInputStream(fos);
        Object data = oso.readObject();
        oso.close();
        return data;
    }

    private static void writeData(String data, Integer val) throws IOException {
        DataObject d = new DataObject(data);
        d.setLol(val);
        File f = new File(TMP_FILE);


        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oso = new ObjectOutputStream(fos);
        oso.writeObject(d);
        oso.close();
    }
}
