package aed;

class ArregloRedimensionableDeRecordatorios {
   private Recordatorio[] arregloDeRecordatorios;
    
    public ArregloRedimensionableDeRecordatorios(){
        Recordatorio[] nuevoArreglo = new Recordatorio[0];
        this.arregloDeRecordatorios = nuevoArreglo;
    }

    public ArregloRedimensionableDeRecordatorios(int n) {
        Recordatorio[] nuevoArreglo = new Recordatorio[n];
        this.arregloDeRecordatorios = nuevoArreglo;
   }

    public int longitud() {
        int res = 0; 
        for (Recordatorio recordatorio : arregloDeRecordatorios) {
            res += 1;
        }
        return res;
    }

    public void agregarAtras(Recordatorio i) {
        Recordatorio[] nuevoArreglo = new Recordatorio[arregloDeRecordatorios.length + 1];
        for (int j = 0; j < arregloDeRecordatorios.length; j++) {
            nuevoArreglo[j] = arregloDeRecordatorios[j];
        }
        nuevoArreglo[nuevoArreglo.length - 1] = i;
        arregloDeRecordatorios = nuevoArreglo;
    }

    public Recordatorio obtener(int i) {
        Recordatorio res = arregloDeRecordatorios[i];
        return res;
    }

    public void quitarAtras() {
        Recordatorio[] nuevoArreglo = new Recordatorio[arregloDeRecordatorios.length + - 1];
        for (int i = 0; i < nuevoArreglo.length; i++) {
            nuevoArreglo[i] = arregloDeRecordatorios[i];
        }
        arregloDeRecordatorios = nuevoArreglo;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        // Implementar
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        // Implementar
        return null;
    }
}
