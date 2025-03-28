package aed;

public class Recordatorio {
    private String mensaje;
    private Fecha fecha;
    private Horario horario;
    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        Fecha otraFecha = new Fecha(fecha);
        this.fecha = otraFecha;
        this.mensaje = mensaje;
        this.horario = horario;
    }

    public Horario horario() {
        return this.horario;
    }

    public Fecha fecha() {
        Fecha otraFecha = new Fecha(fecha);
        return otraFecha;
    }

    public String mensaje() {
        // Implementar
        return this.mensaje;
    }

    @Override
    public String toString() {
        return mensaje + " @ " + fecha.toString() + " " + horario.toString();

    }

    @Override
    public boolean equals(Object otro) {
        if(otro == null || otro.getClass() != this.getClass()){
            return false;
        }else{
            Recordatorio otroRecordatorio = (Recordatorio) otro;
            return this.fecha == otroRecordatorio.fecha() && this.horario == otroRecordatorio.horario() && this.mensaje.equals(otroRecordatorio.mensaje());
        }
    }

}
