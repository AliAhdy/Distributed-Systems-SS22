

import java.net.*;
import java.io.*;

public class UDPServer{
  public static void main( String args[]){
    System.out.println("The Server is running");
    //Two Conference Objects
    Conference conference1 = new Conference("Test");
    conference1.addParticipant("A", "Test", "Test");
    Conference conference2 = new Conference("Testing");
    try{
      //New Server-Socket created with local port-number
      DatagramSocket aSocket = new DatagramSocket (6789);
      //Buffer to receive incoming data
      byte[] buffer = new byte[1000];
      //Communication
      while(true){
        DatagramPacket request = new DatagramPacket (buffer, buffer.length);
        aSocket.receive (request);

        //
        ByteArrayInputStream input = new ByteArrayInputStream(buffer);
        ObjectInputStream inputStream = new ObjectInputStream(input);
        inputStream.close();
       /* try {
          Message message = (Message) inputStream.readObject();
          System.out.println("Request received:" + message);
        }catch (ClassNotFoundException e){
          e.printStackTrace();
        }*/

        System.out.println(" Request: " + new String(request.getData(), 0, request.getLength()));
                                                                          
        DatagramPacket reply = new DatagramPacket (request.getData(),
                request.getLength(), request.getAddress(), request.getPort());
        aSocket.send (reply);
      }
    }catch (SocketException e){ System.out.println(" Socket: " + e.getMessage());
    }catch (IOException e) {System.out.println(" IO: " + e.getMessage());}
  } // main
} //class UDPServer