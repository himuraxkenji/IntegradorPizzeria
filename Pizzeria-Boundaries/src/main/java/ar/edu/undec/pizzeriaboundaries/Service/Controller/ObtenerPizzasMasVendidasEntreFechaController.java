package ar.edu.undec.pizzeriaboundaries.Service.Controller;


import excepciones.PedidoIncompletoException;
import excepciones.PedidosNoEncontradosException;

import input.IObtenerPizzasMasVendidasFechasInput;

import modelo.Pizza;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;

import java.util.ArrayList;
import java.util.HashMap;

@RequestMapping("/")
@RestController
public class ObtenerPizzasMasVendidasEntreFechaController {

    private IObtenerPizzasMasVendidasFechasInput obtenerPizzasMasVendidasEntreFechasInput;



    public ObtenerPizzasMasVendidasEntreFechaController(IObtenerPizzasMasVendidasFechasInput obtenerPizzasMasVendidasEntreFechasInput) {
        this.obtenerPizzasMasVendidasEntreFechasInput = obtenerPizzasMasVendidasEntreFechasInput;
    }

    @ModelAttribute
    LocalDate initLocalDate() {
        return LocalDate.now();
    }

    @RequestMapping(value = "pizzasMasVendidas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> obtenerPizzasMasVendidasEntreFechas(@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)  @ModelAttribute LocalDate fechaInicio, @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)  @ModelAttribute LocalDate fechaFin) {
        try {

            HashMap<Pizza, Integer> lasPizzasMap = this.obtenerPizzasMasVendidasEntreFechasInput.obtenerPizzasMasVendidasEntreFechas(fechaInicio, fechaFin);
            ArrayList<Pizza> losNombres = new ArrayList(lasPizzasMap.keySet());
            ArrayList<Integer> laCantidad = new ArrayList(lasPizzasMap.values());
            HashMap<String, Integer> laListaRanking = new HashMap<>();
            for(int i=0; i<laCantidad.size();++i){
                laListaRanking.put(losNombres.get(i).getNombre(), laCantidad.get(i));
            }

            if (lasPizzasMap.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
                    return ResponseEntity.status(HttpStatus.OK).body(laListaRanking);

        } catch(Exception | PedidoIncompletoException | PedidosNoEncontradosException ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}



