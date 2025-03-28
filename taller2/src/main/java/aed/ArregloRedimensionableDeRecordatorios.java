package aed;

class ArregloRedimensionableDeRecordatorios {
    private Recordatorio[] arregloDeRecordatorios = new Recordatorio[0];

    public ArregloRedimensionableDeRecordatorios(int n) {
        arregloDeRecordatorios = new Recordatorio[n];
   }

    public int longitud() {
        int res = 0; 
        for (Recordatorio recordatorio : arregloDeRecordatorios) {
            res += 1;
        }
        return res;
    }

    public void agregarAtras(Recordatorio i) {
        // Implementar
    }

    public Recordatorio obtener(int i) {
        // Implementar
        return null;
    }

    public void quitarAtras() {
        // Implementar
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        // Implementar
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        // Implementar
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        // Implementar
        return null;
    }
}
