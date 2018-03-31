package TCP.basic_tcp;

public class ClientConversation {

    public static void main(String[] args) {

            TakeUserPass t = new TakeUserPass() ;
            String message = t.get("Enter your message : ") ;

            SendMessage sm = new SendMessage() ;
            sm.send(message) ;

    }
}
