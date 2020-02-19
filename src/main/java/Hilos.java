import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
add('north')
add('south')
 */

public class Hilos extends JFrame implements ActionListener {
    private TextArea area1, area2;
    private Hilo h1,h2;
    private JButton button;

    public Hilos(){
        super("actividad con hilos");
        setLayout(new BorderLayout());

        area1 = new TextArea();
        area2 = new TextArea();
        area1.setEditable(false);
        area2.setEditable(false);

        button = new JButton("Accion");
        button.addActionListener(this);

        h1=new Hilo(area1, 1000);
        h2=new Hilo(area1, 1000);

        h1.start();
        h2.start();

        add("North", area1);
        add("Center", area2);
        add("South", button);
    }

    public static void main(String[] args){
        Hilos h = new Hilos();
        h.setBounds(0,0,300,300);
        h.setVisible(true);
    }

    class Hilo extends Thread {
        private TextArea area;
        private Integer contador;
        private long dormir;
        private boolean bandera;

        public Hilo(TextArea a, long d){
            area=a;
            dormir=d;
            contador=0;
            bandera=true;
        }

        public void pausar(){
            bandera = !bandera;
        }

        public void play(){
            bandera=!bandera;
            notify();
        }

        public void run(){
            while(true){
                if(!bandera){
                    synchronized (this){
                        try{
                            wait();
                        }catch(InterruptedException e){

                        }
                    }
                }else{
                    area.append(String.valueOf(contador) + "\n");
                    try{
                        sleep(dormir);
                    }
                    catch(InterruptedException e){
                    }
                }

            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (h1.bandera){
            h1.pausar();
        }else{
            h1.play();
        }
    }
}
