package TCP.basic_tcp;

import java.io.*;
import java.net.Socket;

public class SendMessage {

    void send(String message) {

        String serverName = "localhost" ;
        int port = 2300 ;

        try {
            System.out.println("Connecting to " + serverName + " on port " + port);
            Socket client = new Socket(serverName, port);
            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            String send = message;

            System.out.println("Client Sent To server : "+send) ;
            out.writeUTF(send);

            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("Server says to client : " + in.readUTF());
            client.close();

        }catch(IOException e) {
            System.out.println("Error catch korche :D");
            e.printStackTrace();
        }
    }
}
