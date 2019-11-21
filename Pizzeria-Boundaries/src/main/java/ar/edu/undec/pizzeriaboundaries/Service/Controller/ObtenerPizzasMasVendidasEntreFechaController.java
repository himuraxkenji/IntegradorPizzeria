package ar.edu.undec.pizzeriaboundaries.Service.Controller;


import excepciones.PedidoIncompletoException;
import excepciones.PedidosNoEncontradosException;

import input.IObtenerPizzasMasVendidasFechasInput;

import modelo.Pizza;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;

import java.util.HashMap;

@RequestMapping("/")
@RestController
public class ObtenerPizzasMasVendidasEntreFechaController {

    private IObtenerPizzasMasVendidasFechasInput obtenerPizzasMasVendidasEntreFechasInput;


    public ObtenerPizzasMasVendidasEntreFechaController(IObtenerPizzasMasVendidasFechasInput obtenerPizzasMasVendidasEntreFechasInput) {
        this.obtenerPizzasMasVendidasEntreFechasInput = obtenerPizzasMasVendidasEntreFechasInput;
    }

    @RequestMapping(value = "pizza_Integer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> obtenerPizzasMasVendidasEntreFechas(@RequestBody LocalDate fechaInicio, @RequestBody LocalDate fechaFin) {
        try {
            HashMap<Pizza, Integer> lasPizzasMap = this.obtenerPizzasMasVendidasEntreFechasInput.obtenerPizzasMasVendidasEntreFechas(fechaInicio, fechaFin);

            if (!lasPizzasMap.isEmpty()) {

                return ResponseEntity.status(HttpStatus.OK).body(lasPizzasMap);
            } else {


                 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch(Exception | PedidoIncompletoException | PedidosNoEncontradosException ex){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
    }
}



