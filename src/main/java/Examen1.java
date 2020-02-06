import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Examen1 extends JFrame implements ActionListener {
    private JTextField textcentro;
    private JButton btnnorte;
    private JTextArea textosur;

    public Examen1(){
        setTitle("Gallegos 2020");
        setLayout(null);

        textcentro = new JTextField("nada aun");
        textcentro.setBounds(90, 100, 100, 30);

        btnnorte = new JButton("copia ya");
        btnnorte.setBounds(90, 10, 150 ,30);

        textosur = new JTextArea();
        textosur.setBounds(60, 150,200,200);
        textosur.setEnabled(false);

        btnnorte.addActionListener(this);

        add(textcentro);
        add(btnnorte);
        add(textosur);
        setBounds(10,10,310,310);
        setVisible(true);
    }

    public static void main(String[] args){
        Examen1 ventana = new Examen1();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("ok");
        textosur.setText(textosur.getText() + "\n" + textcentro.getText());
    }
}
