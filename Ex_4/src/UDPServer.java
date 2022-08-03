import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UDPServer {
    public static void main(String[] args) {
        System.out.println("The Server is running");

        Conference conference1 = new Conference();
        conference1.setName("conf1");
        conference1.addParticipant("Test", "Test", "TT");
        conference1.addParticipant("Ali", "ss", "W");
        Conference conference2 = new Conference();
        conference2.setName("conf2");
        conference2.addParticipant("Amar", "Germany", "PP");

        try {
            //New Server-Socket created with local port number
            DatagramSocket aSocket = new DatagramSocket(6789);
            //Buffer to receive incoming data
            byte[] buffer = new byte[1000];
            //Communication
            while (true){
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);

                //Deserialize the object
                ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(buffer, 0, buffer.length));
                //Read the incoming message
                Message message = (Message) inputStream.readObject();

                if (message.getMethod().equals("add")){
                    System.out.println("Server: New Participant");
                    if (message.getConferenceName().equals("conf1")){
                        conference1.addParticipant(message.getName(), message.getCountry(), message.getCompany());
                    }
                    if (message.getConferenceName().equals("conf2")){
                        conference2.addParticipant(message.getName(), message.getCountry(), message.getCompany());
                    }
                    System.out.println("New Participant added!\n");

                    //String to byte
                    byte[] mes = "Participant added to Conference".getBytes();
                    DatagramPacket reply = new DatagramPacket(mes, mes.length,
                            request.getAddress(), request.getPort());
                    aSocket.send(reply);
                }

                if (message.getMethod().equals("get")){
                    List<String> participantsL = new ArrayList<String>();
                    if (message.getConferenceName().equals("conf1")){
                        participantsL = conference1.getAllP();
                    }
                    if (message.getConferenceName().equals("conf2")){
                        participantsL = conference2.getAllP();
                    }
                    //String outputs
                    String rep = "";
                    Iterator iterator = participantsL.iterator();
                    while (iterator.hasNext()){
                        rep = rep + iterator.next().toString() + "\n";
                    }
                    byte[] mes = rep.getBytes();
                    DatagramPacket reply = new DatagramPacket(mes, mes.length,
                            request.getAddress(), request.getPort());
                    aSocket.send(reply);
                }

                if (message.getMethod().equals("conferenceName")){
                    if (message.getConferenceName().equals("conf1")){
                        byte[] mes = (conference1.getName()).getBytes();
                        DatagramPacket reply = new DatagramPacket(mes, mes.length,
                                request.getAddress(), request.getPort());
                        aSocket.send(reply);
                    }
                    if (message.getConferenceName().equals("conf2")){
                        byte[] mes = (conference2.getName()).getBytes();
                        DatagramPacket reply = new DatagramPacket(mes, mes.length,
                                request.getAddress(), request.getPort());
                        aSocket.send(reply);
                    }
                }
            }

        }catch (IOException | ClassNotFoundException e){
            System.out.println("IO: " + e.getMessage());
        }
    }
}
