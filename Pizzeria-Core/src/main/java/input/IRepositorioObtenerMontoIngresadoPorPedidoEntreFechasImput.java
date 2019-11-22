package input;

import excepciones.FechaIncorrectaException;

import java.time.LocalDate;

public interface IRepositorioObtenerMontoIngresadoPorPedidoEntreFechasImput {
    Double obtenerMontoIngresadoPorPedidoEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) throws FechaIncorrectaException;
}
