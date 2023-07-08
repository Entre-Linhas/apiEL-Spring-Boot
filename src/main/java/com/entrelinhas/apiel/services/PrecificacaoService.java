package com.entrelinhas.apiel.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.entrelinhas.apiel.models.Pedidos;
import com.entrelinhas.apiel.models.Precificacao;
import com.entrelinhas.apiel.repositories.PedidosRepository;
import com.entrelinhas.apiel.repositories.PrecificacaoRepository;

@Service
public class PrecificacaoService {
    private final PrecificacaoRepository precificacaoRepository;
    private final PedidosRepository pedidosRepository;

    public PrecificacaoService(PrecificacaoRepository precificacaoRepository, PedidosRepository pedidosRepository) {
        this.precificacaoRepository = precificacaoRepository;
        this.pedidosRepository = pedidosRepository;
    }

    public Precificacao obterPrecificacaoPorId(Long id) {
        return precificacaoRepository.findById(id).orElse(null);
    }

    public Precificacao criarPrecificacao(Precificacao precificacao) {
        return precificacaoRepository.save(precificacao);
    }

    public Precificacao atualizarPrecificacao(Precificacao precificacao) {
        return precificacaoRepository.save(precificacao);
    }

    public void excluirPrecificacao(Long id) {
        precificacaoRepository.deleteById(id);
    }

    public Precificacao criarPrecificacao(Long id, Precificacao precificacoes) {
        Precificacao precificacao = new Precificacao();
        precificacao.setMaterial(precificacoes.getMaterial());
        precificacao.setPreco(precificacoes.getPreco());
        precificacao.setQuantidade(precificacoes.getQuantidade());

        if (precificacoes.getPreco() != null && precificacoes.getQuantidade() != null){
            BigDecimal quantidade = BigDecimal.valueOf(precificacoes.getQuantidade());
            BigDecimal precoTotal = precificacoes.getPreco().multiply(quantidade);
    precificacoes.setPrecoTotal(precoTotal);
            /* double precoTotal = precificacao.getPreco() * precificacao.getQuantidade(); */
        precificacao.setPrecoTotal(precificacoes.getPrecoTotal());
        }
        if (precificacoes.getPedidos() != null){
        Optional<Pedidos> pedidosOptional = pedidosRepository.findById(id);
    if (pedidosOptional.isPresent()) {
        Pedidos pedidos = pedidosOptional.get();
        precificacao.setPedidos(pedidos);
    } else {
        throw new RuntimeException("Usuário não encontrado com o ID: " + id);
    }}

        return precificacaoRepository.save(precificacao);
    }

    public List<Precificacao> obterTodasPrecificacao() {
        return precificacaoRepository.findAll();
    }
}
