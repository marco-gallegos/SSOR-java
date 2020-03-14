import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Hashtable;

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

    //acctividad 12
    //sobre micronucleo
    // los enteros convertidos son de 4 bytes es decir el array es de length 4
    // basicamente debemos implementar el envia y recibe con datos de las tablas de recepcion y envio o obtenerlas de la interfaz
    private Hashtable tabla1 = new Hashtable();

    //clse que no existe
    class ParMaquinaProceso{
        private int id;
        private String ip;

        public ParMaquinaProceso(int id, String ip){
            this.id = id;
            this.ip = ip;
        }

        public getip(){

        }

        public getid(){

        }
    }

    protected void sendVerdadero(int dest, byte[] message){
        ParMaquinaProceso pmp = tabla1.get(dest);
        if (pmp==null){
            //pmp = dameDestinatarioDesdeInterfaz();
        }
        //actividad 11 se obtiene los de empaquetar y no el arreglo
        byte[] arr = empaqueta(dameIpProceso());

        //...


        DatagramPacket dp = new DatagramPacket(message, message.length, );
    }

    //hio que recibe los paquetes
    public run(){
        byte[] buffer = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
        DatagramSocket ds = dameSocketRecepcion();

        while(seguirEsperandoDatagramas()){
            try{
                println("preparado para recibir msg");
                ds.receive(dp);

                println("averiguando id origen");
                byte[] arr = new byte[4];
                System.arraycopy(buffer,0, arr,0,4);
                // practica 11
                int origen = armaEntero(arr);

                println("averiguando id origen");
                System.arraycopy(buffer,4, arr,0,4);
                // practica 11
                int destino = armaEntero(arr);

                println("averiguando ip origen");
                String iporigen = dp.getAddress().getHostAddress();

                //imprimir datos
                println("buscando si existe el destino");
                Proceso p = dameProcesoLocal();
                if (buffer[1023]==-404){
                    println("recibi un AU");
                    Proceso p2 = dameProcesoLocal(origen);
                    reanudarProceso(p2);
                }

                if (p!=null){
                    byte[] arreglo=tabla2.get(destino);
                    if (arreglo!=null){
                        println("transmision exitosa");
                        tabla2.remove(destino);

                        /**
                         * crear clasequenoexiste
                         * hacer put en tabla1
                         */

                        System.arraycopy(buffer,0,arreglo,0, buffer.length);

                        reanudarProceso(p);
                    }else{
                        // aca va el TA
                    }
                }
                else{
                    // aqui va el AU adress unknow
                    buffer[1023]=-404;
                    DatagramPacket dp2 = new DatagramPacket(buffer, buffer.length);
                    DatagramSocket ds2 = dameSocketEmision();
                    ds2.send(dp2);
                }
            }
        }
    }
}

/**
 * actividad de cierre 2
 * implementar
 */
