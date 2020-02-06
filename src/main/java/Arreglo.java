import java.util.Random;

public class Arreglo {

    public static void main(String[] args){
        Random r = new Random();
        int tam = r.nextInt();
        if (tam == 0){
            tam = 1;
        }

        char[] letras;// = new char[]('BCDEFGHIJKLMNOPQRSTUVWXYZ');



        Arreglo a = new Arreglo();
        //a.metodo(letras); get bytes
    }

    private void metodo(char[] arreglo) {
        String x = "BATMAN";
        int vecesacopiar = arreglo.length/x.length();
    }

    // es un extra si solo muestras los modificados
}
