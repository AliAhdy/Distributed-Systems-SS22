
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UDPClient{

  public static Object Message(){

    ArrayList<Message> messages = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    //Add new Participant
    System.out.println("Name:");
    String name = in.nextLine();

    System.out.println("Company: ");
    String company = in.nextLine();

    System.out.println("Country: ");
    String country = in.nextLine();

    Message messageO = new Message(name, company, country);
    messages.add(messageO);


    return messageO;
  }

  public static void main( String args[]){
   //args[0]: Message
  // args[1]: Server
    Scanner scanner;
    try {
    
      //System.out.println(" Message:  " + args[0]);

      //New Client-Socket created

      DatagramSocket aSocket = new DatagramSocket();
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(baos);
      oos.writeObject(Message());
      byte [] m = baos.toByteArray();

      InetAddress aHost = InetAddress.getByName("localhost");
      int serverPort = 6789;
      //New Package created
      DatagramPacket request = new DatagramPacket (m, m.length,
                                                   aHost, serverPort);
      //Request send into pipe
      aSocket.send (request);


      byte[] buffer = new byte[1000];
      DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
      aSocket.receive (reply);
      System.out.println(" Reply: " + new String(reply.getData()));
      //Close of reply
      aSocket.close();
    }catch (SocketException e){ System.out.println(" Socket: " + e.getMessage());
    }catch (IOException e){ System.out.println(" IO: " + e.getMessage());}
  }
} 
