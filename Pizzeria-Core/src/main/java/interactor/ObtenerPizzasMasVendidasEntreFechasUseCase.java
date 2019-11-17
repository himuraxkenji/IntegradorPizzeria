/**package interactor;

import excepciones.FechaIncorrectaException;
import excepciones.PedidosNoEncontradosException;
import modelo.Pedido;
import modelo.Pizza;
import repositorio.IRepositorioObtenerPedidos;
import repositorio.IRepositorioObtenerPizzasMasVendidasEntreFechas;

import java.time.LocalDate;
import java.util.*;


public class ObtenerPizzasMasVendidasEntreFechasUseCase{

    private IRepositorioObtenerPizzasMasVendidasEntreFechas obtenerPizzasMasVendidasEntreFechasGateWay;
    private IRepositorioObtenerPedidos obtenerPedidosGateWay;

    public ObtenerPizzasMasVendidasEntreFechasUseCase(IRepositorioObtenerPizzasMasVendidasEntreFechas obtenerPizzasMasVendidasGateWay, IRepositorioObtenerPedidos obtenerPedidosGateWay) {
        this.obtenerPizzasMasVendidasEntreFechasGateWay = obtenerPizzasMasVendidasGateWay;
        this.obtenerPedidosGateWay = obtenerPedidosGateWay;
    }

    private boolean mapRepetido(Integer num, Integer compara){
        if(num==compara)
            return true;
        else
            return false;
    }

    private void contadorPizza() {
        Integer Comun = 0;
        Integer Napolitana = 0;
        Integer Especial =0;
        Integer Argentina = 0;
        Integer Palmitos =0;
        Integer DobleMuzza = 0;
        Integer Mexicana =0;
        Integer CuatroQuesos=0;
        Integer Caballo=0;
        Integer Morron=0;

        LinkedHashMap<Integer,ArrayList<Pizza>> lasPizzasOrdenadas = new LinkedHashMap<>();
        ArrayList<Pedido> losPedidos = obtenerPedidosGateWay.obtenerPedidos();
        ArrayList<Pizza> lasPizzaArray = new ArrayList<>();
        ArrayList<Integer> numeroPizzas = new ArrayList<>();



        for(int i=0;i<losPedidos.size();++i) {
            ArrayList<Pizza> pizzasPorPedido = (ArrayList<Pizza>) losPedidos.get(i).getItems();
            for (int j = 0; j < pizzasPorPedido.size(); ++j) {

                if (pizzasPorPedido.get(j).getNombre().contains("Comun")){
                Comun++;
                lasPizzaArray.add(pizzasPorPedido.get(j));
                continue;}
                if (pizzasPorPedido.get(j).getNombre().contains("Napolitana")) {
                Napolitana++;
                lasPizzaArray.add(pizzasPorPedido.get(j));
                continue;}
                if (pizzasPorPedido.get(j).getNombre().contains("Especial")) {
                Especial++;
                lasPizzaArray.add(pizzasPorPedido.get(j));
                continue;}
                if (pizzasPorPedido.get(j).getNombre().contains("Argentina")) {
                Argentina++;
                lasPizzaArray.add(pizzasPorPedido.get(j));
                continue;}
                if (pizzasPorPedido.get(j).getNombre().contains("Palmitos")) {
                Palmitos++;
                lasPizzaArray.add(pizzasPorPedido.get(j));
                continue;}
                if (pizzasPorPedido.get(j).getNombre().contains("DobleMuzza")) {
                DobleMuzza++;
                lasPizzaArray.add(pizzasPorPedido.get(j));
                continue;}
                if (pizzasPorPedido.get(j).getNombre().contains("Mexicana")) {
                Mexicana++;
                lasPizzaArray.add(pizzasPorPedido.get(j));
                continue;}
                if (pizzasPorPedido.get(j).getNombre().contains("CuatroQuesos")) {
                CuatroQuesos++;
                lasPizzaArray.add(pizzasPorPedido.get(j));
                continue;}
                if (pizzasPorPedido.get(j).getNombre().contains("Caballo")) {
                Caballo++;
                lasPizzaArray.add(pizzasPorPedido.get(j));
                continue;}
                if (pizzasPorPedido.get(j).getNombre().contains("Morron")) {
                Morron++;
                lasPizzaArray.add(pizzasPorPedido.get(j));
                continue;}
            }
        }
        numeroPizzas.add(Comun);
        numeroPizzas.add(Napolitana);
        numeroPizzas.add(Especial);
        numeroPizzas.add(Argentina);
        numeroPizzas.add(Palmitos);
        numeroPizzas.add(DobleMuzza);
        numeroPizzas.add(Mexicana);
        numeroPizzas.add(CuatroQuesos);
        numeroPizzas.add(Caballo);
        numeroPizzas.add(Morron);

        numeroPizzas.sort(Comparator.naturalOrder());

        numeroPizzas.sort(Comparator.reverseOrder());



       / for(int z=0 ; z<numeroPizzas.size()-1;++z){
            for(int y=1;y <numeroPizzas.size();++y){
                ArrayList<Pizza> cantidadPorPizza = new ArrayList<>();
                if(numeroPizzas.get(z).equals(numeroPizzas.get(y)));
                    cantidadPorPizza.add(lasPizzaSet.contains());

            }

        }


    }

   public LinkedHashMap<Integer, ArrayList<Pizza>> obtenerPizzasMasVendidasEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) throws FechaIncorrectaException, PedidosNoEncontradosException {
        LinkedHashMap<Integer, ArrayList<Pizza>> lasPizzasContadas = contadorPizza();
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
**/