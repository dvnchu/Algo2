package aed;

public class Horario {
    private int hora;
    private int minutos;
    
    public Horario(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }

    public int hora() {
        return this.hora;
    }

    public int minutos() {
        return this.minutos;
    }

    @Override
    public String toString() {
        String minutosString = "";
        if(this.minutos < 10){
            minutosString = "0" + this.minutos;
        }else {
            minutosString += this.minutos;
        }

       
        return this.hora + ":" + minutosString;
    }

    @Override
    public boolean equals(Object otro) {
        if(otro == null || otro.getClass() != this.getClass()){
            return false;
        }else{
            Horario otroHorario = (Horario) otro;
            return this.hora == otroHorario.hora() && this.minutos == otroHorario.minutos();
        }
    }

}
