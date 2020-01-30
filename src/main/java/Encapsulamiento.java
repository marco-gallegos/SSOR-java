import java.util.HashMap;

class MiFecha {
    private Integer dia,mes,anio;
    public Boolean bisiesto;
    private HashMap<Integer, Integer> monthslimit, monthslimitBisiesto;

    //contructor
    public MiFecha(){
        monthslimit.put(1,31);
        monthslimit.put(2,28);
        monthslimit.put(3,31);
        monthslimit.put(4,30);
        monthslimit.put(5,31);
        monthslimit.put(6,30);
        monthslimit.put(7,31);
        monthslimit.put(8,31);
        monthslimit.put(9,30);
        monthslimit.put(10,31);
        monthslimit.put(11,30);
        monthslimit.put(12,31);

        monthslimitBisiesto.put(1,31);
        monthslimitBisiesto.put(2,29);
        monthslimitBisiesto.put(3,31);
        monthslimitBisiesto.put(4,30);
        monthslimitBisiesto.put(5,31);
        monthslimitBisiesto.put(6,30);
        monthslimitBisiesto.put(7,31);
        monthslimitBisiesto.put(8,31);
        monthslimitBisiesto.put(9,30);
        monthslimitBisiesto.put(10,31);
        monthslimitBisiesto.put(11,30);
        monthslimitBisiesto.put(12,31);

        dia = 1;
        mes = 1;
        anio = 2020;
        bisiesto = esBisiesto(anio);
    }

    private Boolean validar_day(){
        return Boolean.TRUE;
    }

    private Boolean validar_month() {
        return Boolean.TRUE;
    }

    private Boolean validar_year(){
        return Boolean.TRUE;
    }

    private Boolean esBisiesto(Integer anio_validacion){
        if ( (anio_validacion % 4 == 0 || anio_validacion % 400 == 0) && (anio_validacion % 100 != 0) ){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    //uml
    private Boolean verificaDia(){
        return Boolean.TRUE;
    }

    public Integer dameDia(){
        return dia;
    }

    public Integer dameMes(){
        return mes;
    }

    public Integer dameAnio(){
        return anio;
    }

    public Boolean fijaDia(){
        return Boolean.TRUE;
    }

    public Boolean fijaMes(){
        return Boolean.TRUE;
    }

    public Boolean fijaAnio(){
        return Boolean.TRUE;
    }

}

public class Encapsulamiento{

}