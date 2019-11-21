package interactor;


import excepciones.FechaIncorrectaException;
import excepciones.PedidoIncompletoException;
import excepciones.PedidosNoEncontradosException;
import excepciones.PizzaIncompletaException;
import modelo.Pedido;
import modelo.Pizza;
import repositorio.IRepositorioObtenerPedidos;
import repositorio.IRepositorioObtenerPizzasMasVendidasEntreFechas;


import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.*;
import java.util.stream.Collectors;


public class ObtenerPizzasMasVendidasEntreFechasUseCase  {


   private IRepositorioObtenerPizzasMasVendidasEntreFechas obtenerPizzasMasVendidasEntreFechas;
   private IRepositorioObtenerPedidos obtenerPedidosGateWay;


    public ObtenerPizzasMasVendidasEntreFechasUseCase(IRepositorioObtenerPizzasMasVendidasEntreFechas obtenerPizzasMasVendidasEntreFechas, IRepositorioObtenerPedidos obtenerPedidosGateWay) {
        this.obtenerPizzasMasVendidasEntreFechas = obtenerPizzasMasVendidasEntreFechas;
        this.obtenerPedidosGateWay = obtenerPedidosGateWay;
    }

    public HashMap<Pizza, Integer> obtenerPizzasMasVendidasEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) throws FechaIncorrectaException, PedidoIncompletoException, PizzaIncompletaException, PedidosNoEncontradosException {

        if (fechaFin.isBefore(fechaInicio)) {
            throw new FechaIncorrectaException();
        } else {


            List<Pedido> losPedidosEntreFechas = new ArrayList<>();
            List<Pedido> pedidosCore = obtenerPedidosGateWay.obtenerPedidos();


            List<Pizza> cuentaPizza = new ArrayList<>();


            for (Pedido pedido : pedidosCore) {
                if (pedido.getFecha().toLocalDate().plusDays(1).isAfter(fechaInicio) && pedido.getFecha().toLocalDate().minusDays(1).isBefore(fechaFin)) {
                    losPedidosEntreFechas.add(pedido);
                }

            }
            if(losPedidosEntreFechas == null){
                throw new PedidosNoEncontradosException();
            }else {

                for (int i = 0; i < losPedidosEntreFechas.size(); ++i) {
                    List<Pizza> pizzasPorPedido = (ArrayList<Pizza>) losPedidosEntreFechas.get(i).getItems();
                    for (int j = 0; j < pizzasPorPedido.size(); ++j) {

                        cuentaPizza.add(pizzasPorPedido.get(j));

                    }
                }

                Map<Pizza, Integer> pizzasDesordenadas = new HashMap<>();
                for (Pizza pizza : cuentaPizza) {
                    Integer j = pizzasDesordenadas.get(pizza);
                    pizzasDesordenadas.put(pizza, (j == null) ? 1 : j + 1);
                }

                Map<Pizza, Integer> pizzasOrdenadasDesc = pizzasDesordenadas
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.<Pizza, Integer>comparingByValue().reversed())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


                return (LinkedHashMap<Pizza, Integer>) pizzasOrdenadasDesc;
            }

        }
    }


}
