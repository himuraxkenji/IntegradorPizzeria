package repositorio;



import modelo.Pizza;

import java.time.LocalDate;

import java.util.LinkedHashMap;


public interface IRepositorioObtenerPizzasMasVendidasEntreFechas {

    public LinkedHashMap<Pizza, Integer> obtenerPizzasMasVendidasEntreFechas(LocalDate fechaInicio, LocalDate fechaFin);


}
