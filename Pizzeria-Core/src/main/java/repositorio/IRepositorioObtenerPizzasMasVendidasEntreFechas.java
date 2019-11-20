package repositorio;


import java.time.LocalDateTime;

import java.util.ArrayList;



public interface IRepositorioObtenerPizzasMasVendidasEntreFechas {

    ArrayList<String> obtenerPizzasMasVendidasEntreFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin);


}
