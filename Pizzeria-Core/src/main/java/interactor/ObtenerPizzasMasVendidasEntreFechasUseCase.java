package interactor;


import excepciones.FechaIncorrectaException;
import excepciones.PedidosNoEncontradosException;
import modelo.Pedido;
import modelo.Pizza;
import repositorio.IRepositorioObtenerPedidos;
import repositorio.IRepositorioObtenerPizzasMasVendidasEntreFechas;


import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class ObtenerPizzasMasVendidasEntreFechasUseCase {

    private IRepositorioObtenerPizzasMasVendidasEntreFechas obtenerPizzasMasVendidasEntreFechasGateWay;
    private IRepositorioObtenerPedidos obtenerPedidosGateWay;

    public ObtenerPizzasMasVendidasEntreFechasUseCase(IRepositorioObtenerPizzasMasVendidasEntreFechas obtenerPizzasMasVendidasGateWay, IRepositorioObtenerPedidos obtenerPedidosGateWay) {
        this.obtenerPizzasMasVendidasEntreFechasGateWay = obtenerPizzasMasVendidasGateWay;
        this.obtenerPedidosGateWay = obtenerPedidosGateWay;
    }


    private Map<Pizza, Integer> contadorPizza() {

        ArrayList<Pedido> losPedidos = obtenerPedidosGateWay.obtenerPedidos();
        ArrayList<Pizza> cuentaPizza = new ArrayList<>();

        for (int i = 0; i < losPedidos.size(); ++i) {
            ArrayList<Pizza> pizzasPorPedido = (ArrayList<Pizza>) losPedidos.get(i).getItems();
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



        return pizzasOrdenadasDesc;

    }


    public Map<Pizza, Integer> obtenerPizzasMasVendidasEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) throws FechaIncorrectaException, PedidosNoEncontradosException {
        Map<Pizza, Integer> lasPizzasContadas = contadorPizza();
        ArrayList<Pedido> losPedidos = obtenerPedidosGateWay.obtenerPedidos();
        if(fechaFin.isBefore(fechaInicio))
            throw new FechaIncorrectaException();
        if(losPedidos==null)
            throw new PedidosNoEncontradosException();
        else
           lasPizzasContadas= obtenerPizzasMasVendidasEntreFechasGateWay.obtenerPizzasMasVendidasEntreFechas(fechaInicio, fechaFin);

        return lasPizzasContadas;
   }
}
