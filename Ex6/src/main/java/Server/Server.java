package Server;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.Hashtable;

import static java.lang.Integer.parseInt;

public class Server {
    public static void main(String argv[]) throws JMSException, NamingException {
        Conference conference1 = new Conference("Conference1");
        Conference conference2 = new Conference("Conference2");

        //vorgegeben
        Hashtable<String, String> properties = new Hashtable<String, String>();
        properties.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        properties.put(Context.PROVIDER_URL, "tcp://localhost:61616");

        Context context = new InitialContext(properties);//context = associates names with objects

        QueueConnectionFactory connFactory =
                (QueueConnectionFactory) context.lookup("ConnectionFactory");//lookup the connection factory and queue

        QueueConnection conn = connFactory.createQueueConnection();//Create JMS context
        conn.start();

        QueueSession session = conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue q = (Queue) context.lookup("dynamicQueues/queue");
        QueueReceiver receiver = session.createReceiver(q);
        receiver.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if (message instanceof TextMessage) {
                    TextMessage txt = (TextMessage) message;

                    try {
                        String[] data = txt.getText().split(" ");
                        //Add
                        if (parseInt(data[0]) == 1) {
                            //prueft ob conf1 oder 2
                            switch (parseInt(data[4])) {
                                case 1:
                                    conference1.AddPar(data[1], data[2], data[3]);
                                    //Create queue session
                                    QueueSession session1 = conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
                                    //Create dynamic queue
                                    Queue q1 = (Queue) context.lookup("dynamicQueues/queue");
                                    //create sender and put queue inside
                                    QueueSender sender1 = session.createSender(q1);
                                    //Create Message as acknowledgment
                                    TextMessage msg1 = session.createTextMessage();
                                    msg1.setText("Participant added to conference1");
                                    sender1.send(msg1);
                                    break;

                                case 2:
                                    conference2.AddPar(data[1], data[2], data[3]);
                                    Queue q2 = (Queue) context.lookup("dynamicQueues/queue");
                                    QueueSender sender2 = session.createSender(q2);
                                    TextMessage msg2 = session.createTextMessage();
                                    msg2.setText("Participant added to conference2");
                                    sender2.send(msg2);
                                    break;

                                default:
                                    System.out.println("Please choose Conference 1 or Conference 2!");
                                    break;
                            }

                        }else if (parseInt(data[0]) == 2){
                            switch (parseInt(data[1])){
                                case 1:
                                    ArrayList<String> list = conference1.ReturnParName();
                                    String names = "Participants of Conference1!\n";
                                    for (String i : list){
                                        names = names + " " + i;
                                    }
                                    System.out.println(names);
                                    Queue q1 = (Queue) context.lookup("dynamicQueues/queues");
                            }

                        }
                    } catch (JMSException | NamingException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
