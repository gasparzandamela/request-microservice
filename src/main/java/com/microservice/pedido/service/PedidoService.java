package com.microservice.pedido.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.pedido.model.Item;
import com.microservice.pedido.model.Pedido;
import com.microservice.pedido.repository.PedidoRepository;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido createPedido(Pedido pedido) {

        if (pedido.getItens().isEmpty()) {

            for (Item item : pedido.getItens()) {
                item.setPedido(pedido);
            }

        }

        return pedidoRepository.save(pedido);

    }

    public List<Pedido> listarPedidos(Long id) {
        return pedidoRepository.findAll();
    }
}
