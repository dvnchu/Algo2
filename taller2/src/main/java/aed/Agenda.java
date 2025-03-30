package aed;

public class Agenda {
    private Fecha fechaActual;
    private ArregloRedimensionableDeRecordatorios arregloRecords = new ArregloRedimensionableDeRecordatorios();

    public Agenda(Fecha fechaActual) {
    this.fechaActual = fechaActual;
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        arregloRecords.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        String res = fechaActual.toString() + "\n" + "=====" + "\n";
        for (int i = 0; i < arregloRecords.longitud(); i++) {
            if(arregloRecords.obtener(i).fecha().toString().equals(fechaActual.toString())){
            res += arregloRecords.obtener(i).toString() + "\n";}
        }
        return  res;
    }

    public void incrementarDia() {
        fechaActual.incrementarDia();
    }

    public Fecha fechaActual() {
        return fechaActual;
    }

}
