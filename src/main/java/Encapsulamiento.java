/**
 * @author Marco A. Gallegos
 * @date 2020-01-30
 * @description representar en una clase propia una fecha valida
 */

import java.util.HashMap;

public class Encapsulamiento {
    private Integer dia,mes,anio;
    public Boolean bisiesto;
    private HashMap<Integer, Integer> monthslimit, monthslimitBisiesto;

    //contructor
    public Encapsulamiento(){
        System.out.println("okokokok");

        monthslimit = new HashMap<Integer, Integer>();
        monthslimitBisiesto = new HashMap<Integer, Integer>();

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

    private Boolean validar_dia(Integer dia_validar){
        if (bisiesto){
            return dia_validar <= monthslimitBisiesto.get(mes) && dia_validar >= 0;
        }else{
            return dia_validar <= monthslimit.get(mes) && dia_validar >= 0;
        }
    }

    private Boolean validar_month(Integer mes_validar) {
        return mes_validar <= 12 && mes_validar > 0;
    }

    private Boolean validar_anio(Integer anio_validar){
        return anio_validar == anio_validar;
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

    public Boolean fijaDia(Integer day){
        if(validar_dia(day)){
            System.out.println("dia valido");
            dia = day;
            return Boolean.TRUE;
        }else{
            System.out.println("dia invalido");
            return Boolean.FALSE;
        }
    }

    public Boolean fijaMes(Integer month){
        return Boolean.TRUE;
    }

    public Boolean fijaAnio(Integer year){
        return Boolean.TRUE;
    }
}