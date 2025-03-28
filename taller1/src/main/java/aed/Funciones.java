package aed;

class Funciones {
    int cuadrado(int x) {
        return x*x; 
    }

    double distancia(double x, double y) {
        return Math.sqrt(x*x + y*y); 
    }

    boolean esPar(int n) {
        return n % 2 == 0;
    }

    boolean esBisiesto(int n) {
        return (n % 4 == 0 && n % 100 != 0) || n % 400 == 0;
    }

    int factorialIterativo(int n) {
      int result = 1;
      for (int i = n ; i > 0; i--) {
        result *= i;
      } 
      return result;
    }

    int factorialRecursivo(int n) {
        if(n == 0){
            n = 1;
        }else{
            n*= factorialIterativo(n-1);
        }
        return n;
    }

    boolean esPrimo(int n) {
    int contador = 0;
    for (int i = 1; i <= n; i++) {
        if (n % i == 0){
            contador += 1;}
        }
    return contador == 2;
    }

    int sumatoria(int[] numeros) {
        int resultado = 0;
        for (int i : numeros) {
            resultado += i;
        }
        return resultado;
    }

    int busqueda(int[] numeros, int buscado) {
        int res = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado){
                res = i;
            };
        }
        return res;
    }

    boolean tienePrimo(int[] numeros) {
        for(int num : numeros){
            if(esPrimo(num)){
                return true;
            }
        }
        return false;
    }

    boolean todosPares(int[] numeros) {
        for(int num : numeros){
            if(num % 2 != 0){
                return false;
            }
        }
        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }else{
            for (int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i) != s2.charAt(i)){
                    return false;
                }
                }
                return true;
            }
        }



    boolean esSufijo(String s1, String s2) {
        return esPrefijo(reverseString(s1), reverseString(s2));
    }

    //reverse strings auxiliar para usar esPrefijo
    String reverseString(String s){
        String res = "";
        for (int i = s.length()-1; i >= 0; i--) {
        res += s.charAt(i);
        }
        return res;
    }
}
