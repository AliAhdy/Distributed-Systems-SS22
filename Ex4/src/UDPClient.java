import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

    public static void main(String[] args) {
        //1 -->adding new Participant
        //2 -->Displaying all Participants
        //3 -->displaying conference name
        int i = Integer.parseInt(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //Enter data using BufferReader
        //Reading input data with readLine

        switch (i){
            case 1:
                System.out.println("Adding new Participant");
                try {
                    System.out.println("Conference Name: ");
                    String conference = bufferedReader.readLine();
                    System.out.println("Name: ");
                    String name = bufferedReader.readLine();
                    System.out.println("Country: ");
                    String country = bufferedReader.readLine();
                    System.out.println("Company: ");
                    String company = bufferedReader.readLine();
                    Message newMessage = new Message(conference, name, country, company, "add");
                    sendM(newMessage);
                    break;
                }catch (IOException e){
                    e.printStackTrace();
                }

            case 2:
                try {
                    System.out.println("Please enter the conference name: ");
                    String conferenceName = bufferedReader.readLine();
                    Message message = new Message(conferenceName, "", "", "", "get");
                    sendM(message);
                    break;
                }catch (IOException e){
                    e.printStackTrace();
                }

            case 3:
                try {
                    System.out.println("Conference Name: ");
                    String conferenceName = bufferedReader.readLine();
                    Message message = new Message(conferenceName, "", "", "", "conferenceName");
                    sendM(message);

                }catch (IOException e){
                    e.printStackTrace();
                }
        }
    }

    public static void sendM(Serializable s){
        int serverPort = 6789;
        try {
            //Prepare message for the DatagramPackage
            //Creates byte array
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            //Needed to write objects into the byte array (buffer)
            ObjectOutput objectOutput = new ObjectOutputStream(byteArrayOutputStream);
            //Writes object into the byteArrayOutputStream
            objectOutput.writeObject(s);
            //Closes the stream
            objectOutput.close();
            //data retrieved with toByteArray
            byte[] message = byteArrayOutputStream.toByteArray();

            //Socket created
            DatagramSocket aSocket = new DatagramSocket();
            //gives ip of localhost
            InetAddress aHost = InetAddress.getLocalHost();
            //Create request with the message, the host- and port-address
            DatagramPacket request = new DatagramPacket(message, message.length,
                    aHost, serverPort);
            //Send the request
            aSocket.send(request);

            //Receive the reply from the server
            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(reply);
            System.out.println(" Message:\n" + new String(reply.getData(), 0, reply.getLength()));
            aSocket.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
