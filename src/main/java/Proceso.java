public class Proceso {

    public static void main(String[] args){
        Proceso p=new Proceso();

        int a=8;
        int ar[]=new int[1];
        ar[0]=a;

        System.out.println(String.format("variables antes de entrar a valor a : %s ---- ar[0]: %s",a, ar[0]));
        p.valor(a, a);
        System.out.println(String.format("variables despues de valor a : %s ---- ar[0]: %s",a, ar[0]));
        p.referencia(ar,ar);
        System.out.println(String.format("variables despues de referencia a : %s ---- ar[0]: %s",a, ar[0]));
    }

    public void valor(int uno, int dos){
        uno = uno+2;
        dos = dos*dos;
        System.out.println(String.format("dentro de valor uno : %s ---- dos: %s", uno, dos));
    }

    public void referencia(int[] uno, int[] dos){
        uno[0] = 100;
        dos[0] = dos[0]*dos[0];
        System.out.println(String.format("dentro de referencia uno : %s ---- dos: %s", uno[0], dos[0]));
    }

}
