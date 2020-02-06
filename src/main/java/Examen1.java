import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Examen1 extends JFrame implements ActionListener {
    private JLabel labelsur;
    private JButton btncentro;
    private JTextField textonorte;

    public Examen1(){
        setTitle("Gallegos 2020");

        labelsur = new JLabel("nada aun");
        btncentro = new JButton("copia ya");
        btncentro.setSize(150,30);

        textonorte = new JTextField();
        

        btncentro.addActionListener(this);

        add(labelsur);
        add(btncentro);
        add(labelsur);
        setBounds(10,10,310,310);
        setVisible(true);
    }

    public static void main(String[] args){
        Examen1 ventana = new Examen1();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("ok");
    }
}
