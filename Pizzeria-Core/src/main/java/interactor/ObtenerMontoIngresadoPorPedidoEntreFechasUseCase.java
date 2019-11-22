package interactor;

import excepciones.FechaIncorrectaException;
import input.IRepositorioObtenerMontoIngresadoPorPedidoEntreFechasImput;
import repositorio.IObtenerMontoIngresadoPorPedidoEntreFechas;

import java.time.LocalDate;

public class ObtenerMontoIngresadoPorPedidoEntreFechasUseCase implements IRepositorioObtenerMontoIngresadoPorPedidoEntreFechasImput {
    private IObtenerMontoIngresadoPorPedidoEntreFechas repositorio;
    public ObtenerMontoIngresadoPorPedidoEntreFechasUseCase(IObtenerMontoIngresadoPorPedidoEntreFechas repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Double obtenerMontoIngresadoPorPedidoEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) throws FechaIncorrectaException {
        if((fechaInicio.isAfter(LocalDate.now()))||(fechaFin.isAfter(LocalDate.now())))
            throw new FechaIncorrectaException();
        else return repositorio.obtenerMontoIngresadoPorPedidoEntreFechas(fechaInicio,fechaFin);
    }
}
