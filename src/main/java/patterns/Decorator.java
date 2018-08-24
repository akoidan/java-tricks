package patterns;

public class Decorator {
    public static void main(String[] args) {
        DefaultMessage defaultMessage = new DefaultMessage(new DefaultMessageCreator());
        int asd = defaultMessage.printMessage("new_nessage");
        defaultMessage.editMessage(asd, "edited_message");
        defaultMessage.deleteMessage(asd);
    }

    interface MessageCreator {
        int printMessage(String content);
        void deleteMessage(int id);
        void editMessage(int id, String newMessage);
    }

    static class DefaultMessageCreator implements MessageCreator {
        static int i = 0;

        @Override
        public int printMessage(String content) {
            int i = ++DefaultMessageCreator.i;
            System.out.printf("Message %d with content '%s' has been created",  i, content);
            return i;
        }

        @Override
        public void deleteMessage(int id) {
            System.out.printf("message %d has been deleted", id);
        }

        @Override
        public void editMessage(int id, String newMessage) {
            System.out.printf("message %d has been edited to %s", id, newMessage);
        }
    }

    static class DefaultMessage extends MessageDecorator  {
        public DefaultMessage(MessageCreator mc) {
            super(mc);
        }
    }

    static abstract class MessageDecorator implements MessageCreator{

        private final MessageCreator mc;

        public MessageDecorator(MessageCreator mc) {
            this.mc = mc;
        }

        @Override
        public int printMessage(String content) {
           return mc.printMessage(content);
        }

        @Override
        public void deleteMessage(int id) {
            mc.deleteMessage(id);
        }

        @Override
        public void editMessage(int id, String newMessage) {
            mc.editMessage(id, newMessage);
        }
    }


}
