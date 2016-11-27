package oct2016.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 11/26/16.
 */
public class T {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(3);
        List<String> list = new ArrayList<>();
        list = arrayList;
        String a = list.get(0);
    }
}
