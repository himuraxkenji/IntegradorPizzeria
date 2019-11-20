/*package ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion;

import ar.edu.undec.pizzeriaboundaries.Data.EntityMapper.PedidoEntityMapper;
import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.PedidoEntity;
import ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD.IObtenerPedidosCRUD;
import ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD.IObtenerPizzasMasVendidasEntreFechasCRUD;
import excepciones.FechaIncorrectaException;
import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import modelo.Pedido;
import modelo.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IRepositorioObtenerPedidos;
import repositorio.IRepositorioObtenerPizzasMasVendidasEntreFechas;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ObtenerPizzasMasVendidasEntreFechasRepoImpl implements IRepositorioObtenerPizzasMasVendidasEntreFechas , IRepositorioObtenerPedidos {

    @Autowired
    private IObtenerPedidosCRUD obtenerPedidosCRUD;

    @Autowired
    private IObtenerPizzasMasVendidasEntreFechasCRUD obtenerPizzasMasVendidasEntreFechasCRUD;


    @Override
    public List<Pedido> obtenerPedidos() throws PedidoIncompletoException, PizzaIncompletaException {

        List<Pedido> listaPedidos = new ArrayList<>();

        for(PedidoEntity pedido : obtenerPedidosCRUD.findAll()){

            Pedido elPedido = new PedidoEntityMapper().mapeoDataCore(pedido);
            listaPedidos.add(elPedido);
        }
        return listaPedidos;

    }

    @Override
    public ArrayList<String> obtenerPizzasMasVendidasEntreFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) throws FechaIncorrectaException, PedidoIncompletoException, PizzaIncompletaException {


            if(fechaInicio.isAfter(fechaFin)) {
                throw new FechaIncorrectaException();
            }
            else {

                List<Pedido> losPedidos = new ArrayList<>();
                List<Pedido> pedidosCore = obtenerPedidos();


                List<Pizza> cuentaPizza = new ArrayList<>();


                for (Pedido pedido : pedidosCore) {
                    if (pedido.getFecha().plusDays(1).isAfter(fechaInicio) && pedido.getFecha().minusDays(1).isBefore(fechaFin)) {
                        losPedidos.add(pedido);
                    }

                }

                for (int i = 0; i < losPedidos.size(); ++i) {
                    List<Pizza> pizzasPorPedido = (ArrayList<Pizza>) losPedidos.get(i).getItems();
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


                List<Pizza> lasPizasSolas = new ArrayList(pizzasOrdenadasDesc.keySet());
                List<Integer> losNumerosSolos = new ArrayList(pizzasOrdenadasDesc.values());
                List<String> nombresYCantidad = new ArrayList<>();

                for(int z =0; z<lasPizasSolas.size();++z){
                    nombresYCantidad.add(lasPizasSolas.get(z).getNombre() + " "+ losNumerosSolos.get(z));
                }


                return (ArrayList<String>) obtenerPizzasMasVendidasEntreFechasCRUD.findAll(nombresYCantidad);

            }



    }



}

*/