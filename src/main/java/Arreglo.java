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
        char[] modificado = new char[tam];

        int tamletras = letras.length;

        Arreglo a = new Arreglo();

        System.out.println(String.format("size tam : %s", tam));

        for (int i = 0; i < tam; i++){
            //System.out.println(i);
            arreglo[i] = letras[r.nextInt(tamletras)];
            System.out.print(arreglo[i]);
        }
        System.out.println();

        a.metodo(letras);//get bytes
    }

    private void metodo(char[] arreglo) {
        String x = "BATMAN";
        int tamarreglo = arreglo.length;
        int vecesacopiar = tamarreglo/x.length();

    }

    // es un extra si solo muestras los modificados
}
/*
    1. Crear un arreglo de caracteres de forma aleatoria con puras letras Mayúsculas.
    2. Crear un método que reciba un parámetro arreglo de caracteres.
    3. el método copie en dicho arreglo el contenido de una cadena X
    4. Esta cadena X contenga puras Mayúsculas y sea menor al arreglo de caracteres.
    5. copiar en el arreglo la cadena, tantas veces como quepa completa
    6. no usar funciones de copiado del API de Java
    7. el método reciba al menos el parámetro arreglo
    8. justo después de salir de la subrutina, se imprima el contenido del arreglo de caracteres
    9. usar solo variables locales y parámetros
    10. imprimir primero el arreglo original, luego el arreglo corregído y por último sólo las celdas modificadas.
 */