package Client;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws NamingException, JMSException {

        Hashtable<String, String> properties = new Hashtable<String, String>();
        properties.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        properties.put(Context.PROVIDER_URL, "tcp://localhost:61616");

        Context context = new InitialContext(properties);

        QueueConnectionFactory connFactory =
                (QueueConnectionFactory)context.lookup("ConnectionFactory");

        QueueConnection conn = connFactory.createQueueConnection();
        conn.start();
        QueueSession session = conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue q = (Queue) context.lookup("dynamicQueues/queue");

        QueueSender sender = session.createSender(q);

        int choice = 0;
        System.out.println("\n1.Add new Participant to a Conference \n2.Print all participants of a Conference \n3.Search for a conference of a participant \n\nPress any other number for exit!");

        do {
            Scanner scanner = new Scanner(System.in);
            String input = " ";

            choice = scanner.nextInt();
            if (choice == 1){
                input = String.valueOf(choice);
                System.out.println("Enter name of Participant: ");
                Scanner s = new Scanner(System.in);
                String name = s.nextLine();
                input = input + String.valueOf(name);

                System.out.println("Enter Country: ");
                Scanner s1 = new Scanner(System.in);
                String country = s1.nextLine();
                input = input + String.valueOf(country);

                System.out.println("Enter Company: ");
                Scanner s2 = new Scanner(System.in);
                String company = s2.nextLine();
                input = input + String.valueOf(company);

                System.out.println("Choose 1 or 2");
                Scanner s3 = new Scanner(System.in);
                int n = s3.nextInt();
                input = input + String.valueOf(n);

                TextMessage msg = session.createTextMessage();
                msg.setText(input);
                sender.send(msg);
                QueueSession session1 = conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
                Queue q1 = (Queue) context.lookup("dynamicQueues/queue");
                QueueReceiver receiver = session1.createReceiver(q1);
                receiver.setMessageListener(new MessageListener() {
                    @Override
                    public void onMessage(Message message) {

                    }
                });
            }

        }while (choice == 1);
    }
}
