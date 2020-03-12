public class Parametros {
    public static void println(String arg){
        System.out.println(arg);
    }
    public static void print(String arg){
        System.out.print(arg);
    }
    public static void printbytes(byte[] arg){
        print("bytes : ");
        for (int i = 0; i < arg.length; i++){
            print(String.format("%s",arg[i]));
        }
        println("");
    }

    public static void main(String[] args){
        /**
         * este codigo funciona hay que hacerlo segun la practica
         *
        short numero = 100;
        String numero_s = String.valueOf(numero);
        println(String.format("numero original : " + numero));
        println("numero str : " + numero_s);
        byte[] numero_bytes = numero_s.getBytes();
        printbytes(numero_bytes);
        String numero_recuperado = new String(numero_bytes);
        println("numero reuperado str : " + numero_recuperado);
        short numero2 = -1;
        try {
            numero2 = Short.parseShort("10000000");//Short.parseShort(numero_recuperado);
        }catch(NumberFormatException err){
            println("valor fuera de rango o incompatible");
        }catch (Exception err){
            print(err.toString());
        }
        println(String.format("Short Recuperado numero2 : %s", numero2));
         */
    }

    public static byte[] shortToBytes(Short numero){
        byte[] arreglo;
        String numero_s = String.valueOf(numero);
        arreglo = numero_s.getBytes();
        return arreglo;
    }

    public static short bytesToShort(byte[] arreglo){
        String numero_s = new String(arreglo);
        short numero = -1;
        try{
            numero = Short.parseShort(numero_s);
        }catch(NumberFormatException e){
            numero = -1;
        }
        return numero;
    }

    public static byte[] intToBytes(int numero){
        byte[] arreglo;
        String numero_s = String.valueOf(numero);
        arreglo = numero_s.getBytes();
        return arreglo;
    }

    public static int bytesToInt(byte[] arreglo){
        String numero_s = new String(arreglo);
        int numero = -1;
        try{
            numero = Integer.parseInt(numero_s);
        }catch(NumberFormatException e){
            numero = -1;
        }
        return numero;
    }
}
