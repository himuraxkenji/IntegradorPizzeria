package ar.edu.undec.pizzeriaboundaries.Service.ServiceMapper;

import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.ClienteDTO;
import excepciones.ClienteIncompletoException;
import modelo.Barrio;
import modelo.Cliente;

public class ClienteDTOMapper {

    public Cliente mapeoDTOCore(ClienteDTO clienteDTO) {
        Barrio barrio = new BarrioDTOMapper().mapeoDTOCore(clienteDTO.getBarrio());
        try {
            return Cliente.factoryCliente(clienteDTO.getIdCliente(), clienteDTO.getNombre(),
                    clienteDTO.getDireccion(),barrio,clienteDTO.getDocumento());
        } catch (ClienteIncompletoException e) {
            e.printStackTrace();
            return null;
        }
    }
}
