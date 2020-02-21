import java.util.Arrays;
import java.util.Random;

public class Arreglo {

    public static void main(String[] args){
        Random r = new Random();
        int tam = r.nextInt(100);
        if (tam == 0){
            tam = 1;
        }

        char[] letras = "BCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();// = new char[]('BCDEFGHIJKLMNOPQRSTUVWXYZ');
        char[] arreglo = new char[tam];
        char[] original = new char[tam];

        int tamletras = letras.length;

        Arreglo a = new Arreglo();

        System.out.println(String.format("size tam : %s", tam));

        for (int i = 0; i < tam; i++){
            arreglo[i] = letras[r.nextInt(tamletras)];
        }
        a.printarray(arreglo);
        original = Arrays.copyOf(arreglo, tam);

        a.metodo(arreglo);//get bytes

        a.printarray(arreglo);

        a.printdiff(arreglo, original);
    }

    private void printarray(char[] arreglo){
        int tam = arreglo.length;
        for (int i = 0; i < tam; i++){
            System.out.print(arreglo[i]);
        }
        System.out.println();
    }
    private void printdiff(char[] arreglo, char[] original){
        System.out.println("imprimo solo lo que cambio");
        int tam = arreglo.length;
        for (int i = 0; i < tam; i++){
            if (arreglo[i] != original[i]){
                System.out.print(arreglo[i]);
            }else{
                System.out.print("*");
            }
        }
        System.out.println();
    }

    private void metodo(char[] arreglo) {
        String x = "GAVER";
        int tamarreglo = arreglo.length;
        int tamx = x.length();
        int vecesacopiar = tamarreglo/tamx;
        int vecescopiado = 0;
        int contadorcopia = 0;

        for (int i = 0; i < tamarreglo; i++){
            if(contadorcopia>=tamx){
                contadorcopia=0;
                vecescopiado+=1;
            }
            if(vecescopiado >= vecesacopiar){
                break;
            }
            arreglo[i] = x.charAt(contadorcopia);
            contadorcopia+=1;
        }
        System.out.println(String.format("veces copiado %s", vecescopiado));
    }

    // es un extra si solo muestras los modificados
}
