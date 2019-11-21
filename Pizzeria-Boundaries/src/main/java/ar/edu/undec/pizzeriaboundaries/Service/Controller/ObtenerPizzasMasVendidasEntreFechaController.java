package ar.edu.undec.pizzeriaboundaries.Service.Controller;

import excepciones.FechaIncorrectaException;
import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;

import modelo.Pizza;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import repositorio.IRepositorioObtenerPizzasMasVendidasEntreFechas;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.HashMap;


public class ObtenerPizzasMasVendidasEntreFechaController {

    private IRepositorioObtenerPizzasMasVendidasEntreFechas obtenerPizzasMasVendidasEntreFechas;


    public ObtenerPizzasMasVendidasEntreFechaController(IRepositorioObtenerPizzasMasVendidasEntreFechas obtenerPizzasMasVendidasEntreFechas) {
        this.obtenerPizzasMasVendidasEntreFechas = obtenerPizzasMasVendidasEntreFechas;

    }

    @RequestMapping(value = "pizza/Integer", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> obtenerPizzasMasVendidasEntreFechas(@RequestBody LocalDate fechaInicio, @RequestBody LocalDate fechaFin) {
        try {
            HashMap<Pizza, Integer> lasPizzasMap = this.obtenerPizzasMasVendidasEntreFechas.obtenerPizzasMasVendidasEntreFechas(fechaInicio, fechaFin);
            ArrayList<Pizza> laPizzaArray = new ArrayList(lasPizzasMap.keySet());
            ArrayList<Integer> laPizzaCantidad = new ArrayList(lasPizzasMap.values());
            ArrayList<String> lasListadePizzasMasVendidasEntreFechas = new ArrayList<>();

            for (int i = 0; i < laPizzaArray.size(); ++i) {
                lasListadePizzasMasVendidasEntreFechas.add(laPizzaArray.get(i).getNombre() + " " + laPizzaCantidad.get(i).toString());
            }

            if (lasListadePizzasMasVendidasEntreFechas.size() > 0) {

                return ResponseEntity.status(HttpStatus.OK).body(lasListadePizzasMasVendidasEntreFechas);
            } else {


                 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch(Exception | PedidoIncompletoException ex){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
    }
}
