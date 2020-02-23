import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class ClaseAdministradora {
    /*
    hashtables o tuplas se guardan como pila
    enumeration para contar
        hasMoreElements
        keys()
        elements()
        nextElement()


        tabla
            key = integer
            element = materia class
     */

    private Hashtable<Integer,Materia> materias;
    private int contador_id;

    public ClaseAdministradora(){
        materias = new Hashtable<Integer,Materia>();
        contador_id = 0;

        Materia[] m = new Materia[4];
        m[0] = new Materia("I7004","sistemas operativos de red");
        m[1] = new Materia("I7005","metodos matematicos");
        m[2] = new Materia("I7006","modular 1");
        m[3] = new Materia("I7007","optativa 2");

        for (Integer i = 0; i < 4; i++){
            insert(m[i]);
        }
    }

    class Materia {
        private String Clave;
        private String NombreMateria;

        public Materia() {
            Clave = "none";
            NombreMateria = "none";
        }

        public Materia(String clave, String nombremateria){
            Clave = clave;
            NombreMateria = nombremateria;
        }

        public void print(){
            System.out.println(String.format("%s\t\t\t| %s", Clave, NombreMateria));
        }
    }

    public void printHeader(){
        System.out.println("Id Secuencial\t\t| clave\t\t\t| nombre materia");
    }

    public void printSecuencial(String str){
        System.out.print(String.format("%s\t\t\t\t\t| ", str));
    }

    public boolean insert(Materia m){
        //print table
        materias.put(contador_id, m);
        contador_id++;
        printTable();
        return true;
    }

    public boolean insert(String clave, String nombremateria){
        //print table
        materias.put(contador_id, new Materia(clave, nombremateria));
        contador_id++;
        printTable();
        return true;
    }

    public void add(){
        String clave, nombre = "";
        Scanner input = new Scanner(System.in);

        System.out.println("Clave : ");
        clave = input.nextLine();
        System.out.println("Nombre : ");
        nombre = input.nextLine();
        insert(clave,nombre);
    }

    public Materia select(){
        Scanner input = new Scanner(System.in);
        System.out.println("id de la materia : ");
        int id = Integer.parseInt(input.nextLine());
        String ok = "";
        Materia toreturn = new Materia("NA", "no existe");
        try{
            toreturn = materias.get(id);
            ok = toreturn.Clave;
        }catch(NullPointerException e){
            System.out.println("no se encontro la materia");
        }

        if (!ok.isEmpty()){
            return toreturn;
        }else{
            return new Materia("NA", "no existe :C");
        }
    }

    public boolean delete(Integer indice){
        //print table
        try{
            String ok = materias.get(indice).Clave;
        }catch (NullPointerException e){
            System.out.println("no existe el indice");
            return false;
        }
        materias.remove(indice);
        printTable();
        return true;
    }

    public void printTable(){
        // con enumerator o con iterator
        printHeader();
        Enumeration keys = materias.keys();
        while(keys.hasMoreElements()){
            Object ok = keys.nextElement();
            printSecuencial(ok.toString());
            materias.get(ok).print();
        }
    }

    public void printMenu(){
        System.out.print("1 - agregar ");
        System.out.print("2 - ver uno ");
        System.out.print("3 - eliminar ");
        System.out.print("4 - ver tablas ");
        System.out.println("9 - salir");
    }

    public static void main(String[] args){
        ClaseAdministradora adminC = new ClaseAdministradora();
        Integer opc = 0;
        Integer id = 0;
        Scanner input = new Scanner(System.in);

        while (opc != 9){
            adminC.printMenu();
            opc = Integer.parseInt(input.nextLine());

            switch (opc){
                case 1:
                    adminC.add();
                    break;
                case 2:
                    //adminC.printHeader();
                    adminC.select().print();
                    break;
                case 3:
                    System.out.println("ID Eliminar");
                    id = Integer.parseInt(input.nextLine());
                    adminC.delete(id);
                    break;
                case 4:
                    adminC.printTable();
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        }
    }
}
