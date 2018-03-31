package TCP.tcp_unlimited_conversation;

import java.net.*;
import java.io.*;

class ServerConv{

    public static void main(String args[]){

        ServerSocket serverSocket= null;
        try {
            serverSocket = new ServerSocket(2300);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Socket socket= null;
        try {
            socket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DataInputStream inputStream= null;
        try {
            inputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        DataOutputStream outputStream= null;
        try {
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("::: Server Section :::");

        String str= "";
        String str2= "";

        while(!str.equals("exit")){
            try {

                str=inputStream.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Client says: "+str);


            try {
                str2=br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStream.writeUTF(str2);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}
