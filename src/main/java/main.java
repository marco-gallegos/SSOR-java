import java.util.Scanner;

/**
 * @author Marco A. Gallegos
 * @date 2020-01-30
 * @description ejecutar la practica en turno
 */
import java.util.Scanner;

public class main {

    // practica 1
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Integer usuario_input = 0;
        Encapsulamiento ok = new Encapsulamiento();


        while (Boolean.TRUE){
            System.out.println("Dame un dia");
            usuario_input = input.nextInt();
            ok.fijaDia(usuario_input);

            System.out.println("Dame un mes");
            usuario_input = input.nextInt();
            ok.fijaMes(usuario_input);

            System.out.println("Dame un año");
            usuario_input = input.nextInt();
            ok.fijaMes(usuario_input);
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
