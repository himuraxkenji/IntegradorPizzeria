package modelo;

import excepciones.PedidoIncompletoExcpetion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pedido {

    private Integer idPedido;
    private Cliente elCliente;
    private LocalDateTime fecha;
    private Integer numeroPedido;
    private ArrayList<Pizza> items = new ArrayList<Pizza>();


    private Pedido(Integer idPedido, Cliente elCliente, LocalDateTime fecha, ArrayList<Pizza> items, Integer numeroPedido) {
        this.idPedido = idPedido;
        this.elCliente = elCliente;
        this.fecha = fecha;
        this.numeroPedido = numeroPedido;
        this.items = items;
    }

    public static Pedido factoryPedido(Integer idPedido, Cliente elCliente, LocalDateTime fecha, ArrayList<Pizza> items, Integer numeroPedido) throws PedidoIncompletoExcpetion {
        if(idPedido== null || elCliente == null || fecha == null || numeroPedido == null || items == null || items.size() == 0) {
            throw new PedidoIncompletoExcpetion();
        }else{
            return new Pedido(idPedido, elCliente, fecha, items, numeroPedido);
        }

    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public Cliente getElCliente() {
        return elCliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public ArrayList<Pizza> getItems() {
        return items;
    }
}
