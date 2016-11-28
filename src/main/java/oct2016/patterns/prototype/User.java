package oct2016.patterns.prototype;

import java.util.ArrayList;
import java.util.List;


public class User implements Prototype<User> {
    Message message;

    @Override
    public User clone() throws CloneNotSupportedException {
        User res  = (User) super.clone();
        res.message = this.message.clone();
        return res;
    }
}
