import javax.swing.*;


public class Ventana extends JFrame {
    private JLabel label1;
    private JTextField text1;

    private JButton b1,b2,b3;
    private JPanel btnpanel;

    public Ventana(){
        setTitle("Practica 4");
        setLayout(null);
        label1 = new JLabel("hola marco");
        text1 = new JTextField("holalalalal");
        label1.setBounds(150,-100,200,300);
        text1.setBounds(130, 100, 150, 30);
        text1.setEnabled(false);

        b1= new JButton("btn1");
        b2= new JButton("btn2");
        b3 = new JButton("btn3");
        b1.setVisible(true);

        btnpanel = new JPanel();
        btnpanel.add(b1);
        btnpanel.add(b2);
        btnpanel.add(b3);
        btnpanel.setVisible(true);
        btnpanel.setBounds(50, 150,300,50);

        add(label1);
        add(text1);
        add(btnpanel);
    }

    public static void main(String[] args){
        Ventana inicial = new Ventana();
        inicial.setBounds(0, 0, 400, 300);
        inicial.setVisible(true);
        inicial.setLocationRelativeTo(null);
    }
}
