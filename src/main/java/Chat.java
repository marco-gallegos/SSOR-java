import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat extends JFrame implements ActionListener {
    private JLabel labelip,labelmsg;
    private JTextField fieldip, fieldmsg;
    private JButton btnenviar;

    public Chat(){
        setLayout(new GridLayout(20, 10));
        setVisible(true);
        Integer textw = 200;
        Integer texth = 10;

        JPanel ippanel= new JPanel();
        labelip = new JLabel("IP :");
        fieldip = new JTextField("127.0.0.1");
        fieldip.setSize(textw, texth);
        ippanel.add(labelip);
        ippanel.add(fieldip);

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
