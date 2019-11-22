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

    @RequestMapping(value = "pizzasMasVendidas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> obtenerPizzasMasVendidasEntreFechas(@PathVariable LocalDate fechaInicio, @PathVariable LocalDate fechaFin) {
        try {

            HashMap<Pizza, Integer> lasPizzasMap = this.obtenerPizzasMasVendidasEntreFechasInput.obtenerPizzasMasVendidasEntreFechas(fechaInicio, fechaFin);

            if (lasPizzasMap.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
                    return ResponseEntity.status(HttpStatus.OK).body(lasPizzasMap);

        } catch(Exception | PedidoIncompletoException | PedidosNoEncontradosException ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}



