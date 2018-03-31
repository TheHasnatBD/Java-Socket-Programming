package TCP.basic_tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ServerConversation {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket;
            int port = 2300;
            serverSocket = new ServerSocket(port);
            //serverSocket.setSoTimeout(10000);

            System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");

            while (true) {

                Socket server = serverSocket.accept();
                System.out.println("Just connected to " + server.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(server.getInputStream());

                String st = in.readUTF();
                System.out.println("Server Receive : " + st);
                String upper = st.toUpperCase();
                System.out.println("Upper case message : " + upper);

                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF(upper + "" + server.getLocalSocketAddress());

                server.close();
            }

            }catch(SocketTimeoutException s){
                System.out.println("Socket timed out!");
                //break;
            } catch(IOException e){
                e.printStackTrace();
                //break;
            }

    }
}
