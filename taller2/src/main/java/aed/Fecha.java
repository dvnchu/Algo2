package aed;

public class Fecha {
    private int dia;
    private int mes;

    public Fecha(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
    }

    public Fecha(Fecha fecha) {
        this.dia = fecha.dia;
        this.mes = fecha.mes;
    }

    public Integer dia() {
        return this.dia;
    }

    public Integer mes() {
        return this.mes;
    }

    public String toString() {
        return this.dia + "/" + this.mes;
    }

    @Override
    public boolean equals(Object otra) {
        if(otra == null || otra.getClass() != this.getClass()){
            return false;
        }else{
        Fecha otraFecha = (Fecha) otra; 
        return this.dia == otraFecha.dia() && this.mes == otraFecha.mes();
        } 
    }

    public void incrementarDia() {
        if(mes == 12 && dia == 31){
            dia = 1;
            mes = 1;
        }
        else if(this.dia < diasEnMes(this.mes)){
            this.dia += 1;
        }else{
            this.mes += 1;
            this.dia = 1;
        }
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
