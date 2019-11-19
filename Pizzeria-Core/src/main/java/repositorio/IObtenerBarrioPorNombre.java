package repositorio;

import modelo.Barrio;

import java.util.Collection;

public interface IObtenerBarrioPorNombre {
    Collection<Barrio> obtenerBarrioPorNombre(String nombre);
}
