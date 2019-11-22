package ar.edu.undec.pizzeriaboundaries.Service.Controller;

import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.ClienteDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ServiceMapper.ClienteDTOMapper;
import excepciones.PedidoIncompletoException;
import input.IObtenerPedidosInput;
import modelo.Pedido;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/")
@RestController
public class ObtenerPedidosController {

    private IObtenerPedidosInput obtenerPedidosInput;

    public ObtenerPedidosController(IObtenerPedidosInput obtenerPedidosInput) {
        this.obtenerPedidosInput = obtenerPedidosInput;
    }


    @RequestMapping(value = "pedidos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> obtenerPedidos() {
        try{
            List<Pedido> resultado = this.obtenerPedidosInput.obtenerPedidos();
            if(resultado.isEmpty()) ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
                return ResponseEntity.status(HttpStatus.OK).body(resultado);

        }catch(Exception | PedidoIncompletoException ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
