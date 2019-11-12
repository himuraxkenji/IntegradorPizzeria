package ar.edu.undec.pizzeriaboundaries.Data.EntityMapper;

import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.ClienteEntity;
import excepciones.BarrioIncompletoException;
import excepciones.ClienteIncompletoException;
import modelo.Barrio;
import modelo.Cliente;

public class ClienteEntityMapper {

    public ClienteEntity mapeoCoreData(Cliente clienteCore) {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setIdCliente(clienteCore.getIdCliente());
        clienteEntity.setNombre(clienteCore.getNombre());
        clienteEntity.setDireccion(clienteCore.getDireccion());
        clienteEntity.setBarrio(new BarrioEntityMapper().mapeoCoreData(clienteCore.getElBarrio()));
        clienteEntity.setDocumento(clienteCore.getDocumento());
        return clienteEntity;
    }

    public Cliente mapeoDataCore(ClienteEntity clienteEntity) {
        try {
            return Cliente.factoryCliente(clienteEntity.getIdCliente(),clienteEntity.getNombre(),clienteEntity.getDireccion(),Barrio.factoryBarrio(clienteEntity.getBarrio().getId_barrio(), clienteEntity.getBarrio().getNombre()), clienteEntity.getDocumento());
        } catch (ClienteIncompletoException | BarrioIncompletoException e) {
            e.printStackTrace();
            return null;
        }
    }
}
