import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Chat extends JFrame implements ActionListener {
    private JLabel labelip,labelmsg;
    private JTextField fieldip, fieldmsg;
    private JTextArea chatArea;
    private JButton btnenviar;

    class Receptor extends Thread{
        public Receptor(){
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
                    System.out.print("IP emisora: "+dp.getAddress().toString()+":");
                    System.out.println(new String(buffer,0,dp.getLength()));
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

    public Chat(){
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
        fieldmsg.setSize(textw, texth);
        msgepanel.add(labelmsg);
        msgepanel.add(fieldmsg);

        JPanel btnpanel= new JPanel();
        btnenviar = new JButton("Enviar");
        btnenviar.addActionListener(this);
        btnpanel.add(btnenviar);

        add(ippanel);
        add(msgepanel);
        add(chatpanel);
        add(btnpanel);
        setBounds(0, 0, 600, 700);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        Chat minichat = new Chat();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
    }
}
