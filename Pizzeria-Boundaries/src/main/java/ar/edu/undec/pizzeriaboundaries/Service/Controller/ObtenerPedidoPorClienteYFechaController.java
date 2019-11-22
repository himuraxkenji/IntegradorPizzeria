package ar.edu.undec.pizzeriaboundaries.Service.Controller;

import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.ClienteDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ServiceMapper.ClienteDTOMapper;
import excepciones.BarrioIncompletoException;
import excepciones.ClienteIncompletoException;
import excepciones.FechaIncorrectaException;
import excepciones.PedidoIncompletoException;
import input.IRepositorioObtenerPedidoPorClienteYFechaImput;
import modelo.Pedido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/")
@RestController
public class ObtenerPedidoPorClienteYFechaController {
    private IRepositorioObtenerPedidoPorClienteYFechaImput iRepositorioObtenerPedidoPorClienteYFechaImput;
    public ObtenerPedidoPorClienteYFechaController(IRepositorioObtenerPedidoPorClienteYFechaImput iRepositorioObtenerPedidoPorClienteYFechaImput) {
        this.iRepositorioObtenerPedidoPorClienteYFechaImput = iRepositorioObtenerPedidoPorClienteYFechaImput;
    }

    @RequestMapping(value = "pedido/cliente/{cliente}/fecha/{fecha}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> obtenerPedidoPorClienteYFecha(@PathVariable("cliente") ClienteDTO cliente,@PathVariable("fecha") LocalDateTime fecha) {
        try{
            List<Pedido> resultado = this.iRepositorioObtenerPedidoPorClienteYFechaImput.obtenerPedidoPorClienteYfecha(new ClienteDTOMapper().mapeoDTOCore(cliente),fecha);
            if(resultado.size() > 0)
                return ResponseEntity.status(HttpStatus.OK).body(resultado);
            else return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(Exception | PedidoIncompletoException ex){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
    }
}
