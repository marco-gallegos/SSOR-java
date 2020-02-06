import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ventana5 extends JFrame implements ActionListener{
    private JLabel label1;
    private JTextField text1;

    private JButton b1,b2,b3;
    private JPanel btnpanel;

    public Ventana5(){
        setTitle("Practica 5");
        setLayout(null);
        label1 = new JLabel("hola marco");
        text1 = new JTextField("holalalalal");
        label1.setBounds(150,-100,200,300);
        text1.setBounds(130, 100, 150, 30);
        //text1.setEnabled(false);

        b1= new JButton("Click Me");
        b2= new JButton("btn2");
        b3 = new JButton("btn3");
        b1.setVisible(true);
        b1.addActionListener(this);//Registering ActionListener to the button
        b2.addActionListener(this);//Registering ActionListener to the button
        b3.addActionListener(this);//Registering ActionListener to the button

        btnpanel = new JPanel();
        btnpanel.add(b1);
        btnpanel.add(b2);
        btnpanel.add(b3);
        btnpanel.setVisible(true);
        btnpanel.setBounds(50, 150,300,50);

        add(label1);
        add(text1);
        add(btnpanel);

        // eventos

    }

    //Overriding actionPerformed() method
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
        System.out.println(e.getSource());

        if (e.getSource() == b1){
            System.out.println("es el boton 1");
            label1.setText(text1.getText());
        }
        if (e.getSource() == b2){
            System.out.println("es el boton 2");
            getContentPane().setBackground(Color.pink);
        }
        if (e.getSource() == b3){
            System.out.println("es el boton 3");
            getContentPane().setBackground(Color.BLACK);
        }
    }

    public static void main(String[] args){
        Ventana5 inicial = new Ventana5();
        inicial.setBounds(0, 0, 400, 300);
        inicial.setVisible(true);
        inicial.setLocationRelativeTo(null);

    }
}
