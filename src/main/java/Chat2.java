import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;

public class Chat2 extends JFrame {
    private TextField campoIP;
    private TextArea areaChat;
    private TextField campoMensaje;
    public Button b;

    public Chat2(){
        campoIP = new TextField(11);
        //add(campoIP);
        //Etiqueta “IP”		A la izquierda del Campo IP
        add(new Label("IP: "));
        //A-3	Area Texto Inhabilitada y solo para mostrar el mensaje de red arribado
        areaChat=new TextArea();
        areaChat.setEditable(false);
        //A-4	Campo Mensaje	Para insertar el mensaje a enviar a la IP destino
        campoMensaje=new TextField(25);
        add(campoMensaje);
        //A-5	Etiqueta “Mensaje”	A la izquierda del Campo Mensaje
        add(new Label("Mensaje: "));

        //A-6	Botón			Para accionar el evento de envío de mensaje
        b=new Button("Enviar");
        //A-7	Titulo			Un título para la ventana de la interfaz gráfica
        setTitle("Chat Version Premium");
        setLayout(new BorderLayout());
        add("North", campoIP);
        add("Center",areaChat);
        add(campoMensaje);
        add("South",b);
        //addWindowListener(this);
        setSize(500,500);
        //System.exit(0);
    }


    public static void main(String[] args)
    {
        Chat2 ventanaChat=new Chat2();
        ventanaChat.setVisible(true);
    }
}
