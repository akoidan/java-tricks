package oct2016.patterns.prototype;


public class Message implements Prototype<Message>{

    String context;

    @Override
    public Message clone() throws CloneNotSupportedException {
        return (Message) super.clone();
    }


}
