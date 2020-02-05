import javafx.animation.Interpolator;

import java.util.Scanner;

/**
 * @author Marco A. Gallegos
 * @date 2020-01-30
 * @description ejecutar la practica en turno
 */
import java.util.Scanner;

public class main {

    //practica 4
    public static void main(String[] args){

    }
    /*
        // practica 1
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Integer usuario_input = 0;
        Encapsulamiento ok = new Encapsulamiento();
        Boolean status;


        while (Boolean.TRUE){
            String fecha = "";
            fecha += String.format("fecha : %s-%s-%s", ok.dameAnio(), ok.dameMes(), ok.dameDia());
            System.out.println(fecha);

            System.out.println("Dame un año");
            usuario_input = input.nextInt();
            status = ok.fijaAnio(usuario_input);
            System.out.println(status);

            System.out.println("Dame un mes");
            usuario_input = input.nextInt();
            status = ok.fijaMes(usuario_input);
            System.out.println(status);

            System.out.println("Dame un dia");
            usuario_input = input.nextInt();
            status = ok.fijaDia(usuario_input);
            System.out.println(status);
        }

        return;
    }
    /*
    test
    public static void main(String args[]){
        Encapsulamiento test = new Encapsulamiento();
        System.out.println("hola amor mio");
        test.ok();
    }
     */
}
