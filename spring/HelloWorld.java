package spring;

public class HelloWorld {
   public ToString message;

   public void setMessage(ToString message){
      this.message  = message;
   }

   public void getMessage(){
      System.out.println("Your Message : " + message);
   }
}