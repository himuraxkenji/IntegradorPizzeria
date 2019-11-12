package ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion;

import ar.edu.undec.pizzeriaboundaries.Data.EntityMapper.ClienteEntityMapper;
import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.ClienteEntity;
import ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD.IModificarClienteCRUD;
import modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IRepositorioModificarCliente;

@Service
public class ActualizarClienteRepoImpl implements IRepositorioModificarCliente {

    @Autowired
    IModificarClienteCRUD modificarClienteCRUD;

    @Override
    public Boolean actualizar(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntityMapper().mapeoCoreData(cliente);
        return modificarClienteCRUD.save(clienteEntity) != null;
    }


    @Override
    public Cliente findByDocumento(String documento) {
        Cliente clienteAModificar = new ClienteEntityMapper().mapeoDataCore(modificarClienteCRUD.findByDocumento(documento));

        return clienteAModificar;
    }
}
