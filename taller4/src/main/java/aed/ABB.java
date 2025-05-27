package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
  // Agregar atributos privados del Conjunto
  private Nodo raiz;
  private int cardinal;

  private class Nodo {
    private T valor;
    private Nodo izq;
    private Nodo der;
    private Nodo padre;

    public Nodo(T x) {
      valor = x;
      izq = null;
      der = null;
      padre = null;
    }

    public void setIzq(Nodo i) {
      izq = i;
    }

    public void setPadre(Nodo i) {
      padre = i;
    }

    public void setDer(Nodo i) {
      der = i;
    }

    public void setValor(T i) {
      valor = i;
    }
  }

  public ABB() {
    raiz = null;
    cardinal = 0;
  }

  public int cardinal() {
    return cardinal;
  }

  public T minimo() {
    if (raiz == null) {
      return null;
    }
    Nodo actual = raiz;
    while (actual.izq != null) {
      actual = actual.izq;
    }
    return actual.valor;
  }

  public T maximo() {
    if (raiz == null) {
      return null;
    }
    Nodo actual = raiz;
    while (actual.der != null) {
      actual = actual.der;
    }
    return actual.valor;
  }

  public void insertar(T elem) {
    if (raiz == null) {
      raiz = new Nodo(elem);
      cardinal += 1;
    } else {
      Nodo actual = raiz;
      while (actual != null) {
        if (actual.valor.compareTo(elem) == 0) {
          return;
        } else if (actual.valor.compareTo(elem) > 0) {
          if (actual.izq == null) {
            actual.izq = new Nodo(elem);
            actual.izq.setPadre(actual);
            cardinal += 1;
            return;
          } else {
            actual = actual.izq;
          }
        } else if (actual.valor.compareTo(elem) < 0) {
          if (actual.der == null) {
            actual.der = new Nodo(elem);
            actual.der.setPadre(actual);
            cardinal += 1;
            return;
          } else {
            actual = actual.der;
          }
        }
      }
    }

  }

  public boolean pertenece(T elem) {
    if (raiz == null) {
      return false;
    }
    Nodo actual = raiz;
    while (actual != null) {
      if (actual.valor.compareTo(elem) == 0) {
        return true;
      } else if (actual.valor.compareTo(elem) > 0) {
        actual = actual.izq;
      } else if (actual.valor.compareTo(elem) < 0) {
        actual = actual.der;
      }
    }
    return false;
  }

  public void borrarNodo(Nodo nodo) {
    Nodo hijo = null;

    if (nodo.izq != null) {
      hijo = nodo.izq;
    } else if (nodo.der != null) {
      hijo = nodo.der;
    }

    if (nodo.padre == null) {
      raiz = hijo;
    } else {
      if (nodo.padre.izq == nodo) {
        nodo.padre.setIzq(hijo);
      } else {
        nodo.padre.setDer(hijo);
      }
    }
    if (hijo != null) {
      hijo.setPadre(nodo.padre);
    }
  }

  public void eliminar(T elem) {
    if (raiz == null || !pertenece(elem)) {
      return;
    }
    Nodo actual = raiz;

    while (actual.valor.compareTo(elem) != 0) {
      if (actual.valor.compareTo(elem) > 0) {
        actual = actual.izq;
      } else {
        actual = actual.der;
      }
    }

    if (actual.izq != null && actual.der != null) {
      Nodo sucesor = actual.der;
      while (sucesor.izq != null) {
        sucesor = sucesor.izq;
      }
      actual.setValor(sucesor.valor);
      borrarNodo(sucesor);
    } else {
      borrarNodo(actual);
    }

    cardinal -= 1;
  }

  public String toString() {
    Iterador<T> iterador = iterador();
    String res = "{";
    boolean primero = true;
    while (iterador.haySiguiente()) {
      if (primero) {
        res += iterador.siguiente().toString();
        primero = false;
      } else {
        res += ",";
        res += iterador.siguiente().toString();
      }
    }
    res += "}";
    return res;
  };

  private class ABB_Iterador implements Iterador<T> {
    private Nodo _actual;
    private List<T> lista;
    private int indice = 0;

    public ABB_Iterador() {
      lista = new ArrayList<>();
      if (raiz != null) {
        _actual = raiz;
        listaOrdenada(_actual);
      }
    }

    private void listaOrdenada(Nodo n) {
      if (n == null)
        return;
      listaOrdenada(n.izq);
      lista.add(n.valor);
      listaOrdenada(n.der);
    }

    public boolean haySiguiente() {
      return indice < lista.size();
    }

    public T siguiente() {
      T valor = lista.get(indice);
      indice++;
      return valor;
    }

  }

  public Iterador<T> iterador() {
    return new ABB_Iterador();
  }
}
