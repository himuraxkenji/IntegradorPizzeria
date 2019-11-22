package ar.edu.undec.pizzeriaboundaries.Service.Controller;

import excepciones.FechaIncorrectaException;
import input.IRepositorioObtenerMontoIngresadoPorPedidoEntreFechasImput;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequestMapping("/")
@RestController
public class ObtenerMontoIngresadoPorPedidoEntreFechasController {
    private IRepositorioObtenerMontoIngresadoPorPedidoEntreFechasImput iRepositorioObtenerMontoIngresadoPorPedidoEntreFechasImput;
    public ObtenerMontoIngresadoPorPedidoEntreFechasController(IRepositorioObtenerMontoIngresadoPorPedidoEntreFechasImput iRepositorioObtenerMontoIngresadoPorPedidoEntreFechasImput) {
        this.iRepositorioObtenerMontoIngresadoPorPedidoEntreFechasImput = iRepositorioObtenerMontoIngresadoPorPedidoEntreFechasImput;
    }
    @RequestMapping(value = "pedido/fechaInicio/{fechaInicio}/fechaFin/{fechaFin}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> obtenerMontoIngresadoPorPedidoEntreFechasImput(@PathVariable("fechaInicio") LocalDate fechaInicio,@PathVariable("fechaFin") LocalDate fechaFin) throws FechaIncorrectaException {
        try{
            Double monto = iRepositorioObtenerMontoIngresadoPorPedidoEntreFechasImput.obtenerMontoIngresadoPorPedidoEntreFechas(fechaInicio,fechaFin);
            if((monto !=null)&&(!monto.equals(0)) ) return ResponseEntity.status(HttpStatus.OK).body(monto);
            else return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(0);
        }
    }
}
