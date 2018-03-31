package TCP.tcp_unlimited_conversation;

import java.net.*;
import java.io.*;

class ClientConv{
    public static void main(String args[]){

        Socket socket= null;
        try {
            socket = new Socket("localhost",2300);
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

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));


        String str="";
        String str2="";


        System.out.println("::: Client Section :::");

        while(!str.equals("exit")){
            System.out.print("Write to server : ");
            try {
                str=bufferedReader.readLine();
            } catch (IOException e) {
                System.out.println("Error For read line");
                e.printStackTrace();
            }
            try {
                outputStream.writeUTF(str);
            } catch (IOException e) {
                System.out.println("Error for write ");
                e.printStackTrace();
            }
            try {
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                str2=inputStream.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Server says: "+str2);

            //String upper=str2.toUpperCase();
            //System.out.println("Server says(UPPERCASE): "+upper);
        }

        try {
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Output stream close");
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("Socket close");
            e.printStackTrace();
        }
    }
}
