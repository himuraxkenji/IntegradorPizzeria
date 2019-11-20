package interactor;


import excepciones.FechaIncorrectaException;
import excepciones.PedidoIncompletoException;
import excepciones.PedidosNoEncontradosException;
import excepciones.PizzaIncompletaException;
import modelo.Pedido;
import modelo.Pizza;
import repositorio.IRepositorioObtenerPedidos;
import repositorio.IRepositorioObtenerPizzasMasVendidasEntreFechas;


import javax.xml.ws.ServiceMode;
import java.time.LocalDateTime;

import java.util.*;
import java.util.stream.Collectors;


public class ObtenerPizzasMasVendidasEntreFechasUseCase  {

    private IRepositorioObtenerPizzasMasVendidasEntreFechas obtenerPizzasMasVendidasEntreFechasGateWay;


    public ObtenerPizzasMasVendidasEntreFechasUseCase(IRepositorioObtenerPizzasMasVendidasEntreFechas obtenerPizzasMasVendidasGateWay, IRepositorioObtenerPedidos obtenerPedidosGateWay) {
        this.obtenerPizzasMasVendidasEntreFechasGateWay = obtenerPizzasMasVendidasGateWay;

    }





    public List<String> obtenerPizzasMasVendidasEntreFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) throws FechaIncorrectaException, PedidoIncompletoException, PizzaIncompletaException {

        if(fechaFin.isBefore(fechaInicio))
            throw new FechaIncorrectaException();

        else
          return obtenerPizzasMasVendidasEntreFechasGateWay.obtenerPizzasMasVendidasEntreFechas(fechaInicio, fechaFin);


   }
}
