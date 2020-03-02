import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;

public class Examen2 extends JFrame implements ActionListener {
    private JLabel labelip,labelmsg;
    private JTextField fieldip, fieldmsg;
    private JTextArea chatArea;
    private JButton btnenviar;

    class Receptor extends Thread {
        private JTextArea chatbox;


        public Receptor(JTextArea box){
            chatbox = box;
        }

        public void run(){
            DatagramSocket socketRecepcion;
            DatagramPacket dp;
            int puertoEntrada=2001;
            byte[] buffer=new byte[1024];
            System.out.print("Iniciando socket recepcion en puerto "+puertoEntrada+"...");
            try{
                socketRecepcion=new DatagramSocket(puertoEntrada);
                System.out.println("hecho");
                dp=new DatagramPacket(buffer,buffer.length);
                while(true){//deseable validar con bandera
                    socketRecepcion.receive(dp);
                    System.out.print("IP emisora: "+dp.getAddress().toString()+": ");
                    String mensaje = new String(buffer,0,dp.getLength());
                    System.out.println(mensaje);
                    chatbox.append(mensaje + "\n");
                }
                //socketRecepcion.close();//código inalcanzable sin bandera
            }catch(SocketException e){
                System.out.println("Error iniciando socket: "+e.getMessage());
            }catch(IOException e){
                System.out.println("IOException: "+e.getMessage());
            }
            System.out.print("Cerrando socket recepcion...");
            System.out.println("hecho");
        }
    }

    public Examen2(){
        setTitle("marco 2020-02-28");
        setLayout(new GridLayout(4, 10));
        setVisible(true);
        Integer textw = 200;
        Integer texth = 10;

        JPanel ippanel= new JPanel();
        labelip = new JLabel("IP :");
        fieldip = new JTextField("127.0.0.1");
        fieldip.setSize(textw, texth);
        ippanel.add(labelip);
        ippanel.add(fieldip);

        JPanel chatpanel = new JPanel();
        chatArea = new JTextArea();
        chatArea.setColumns(30);
        chatArea.setRows(20);
        chatpanel.add(chatArea);


        JPanel msgepanel= new JPanel();
        labelmsg = new JLabel("Mensaje");
        fieldmsg = new JTextField("escribe tu mensaje aca");
        //fieldmsg.setSize(textw, texth);
        fieldmsg.setColumns(30);

        msgepanel.add(labelmsg);
        msgepanel.add(fieldmsg);

        JPanel btnpanel= new JPanel();
        btnenviar = new JButton("Enviar");
        btnenviar.addActionListener(this);
        btnpanel.add(btnenviar);

        add(ippanel);
        add(chatpanel);
        add(msgepanel);
        add(btnpanel);
        setBounds(0, 0, 600, 700);


        Receptor hiloReceptor = new Receptor(chatArea);
        hiloReceptor.start();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        Examen2 exam = new Examen2();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println(fieldmsg.getText());
        System.out.println(fieldip.getText());


        DatagramSocket socketEmision;
        DatagramPacket dp;
        //String ip=args[0];
        String ip=fieldip.getText();
        //String mensaje=args[1];
        String mensaje=fieldmsg.getText();
        //int puertoSalida=2002;
        byte[] buffer;
        //System.out.print("Iniciando socket emision en puerto "+puertoSalida+"...");
        try{
            socketEmision=new DatagramSocket();  //constructor sobrecargado para recibir o no un #puerto
            System.out.println("hecho");
            buffer=mensaje.getBytes();
            dp=new DatagramPacket(buffer,buffer.length, InetAddress.getByName(ip),2001);
            socketEmision.send(dp);
            System.out.print("Cerrando socket emision...");
            socketEmision.close();
            System.out.println("hecho");
        }catch(SocketException e){
            System.out.println("Error iniciando socket: "+e.getMessage());
        }catch(UnknownHostException e){
            System.out.println("UnknownHostException: "+e.getMessage());
        }catch(IOException e){
            System.out.println("IOException: "+e.getMessage());
        }
    }
}
