package com.entrelinhas.apiel.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entrelinhas.apiel.models.Ferramentas;
import com.entrelinhas.apiel.models.Perfil;
import com.entrelinhas.apiel.repositories.FerramentasReposity;

@Service
public class FerramentasService {
    private final FerramentasReposity ferramentasRepository;
    private static final Logger logger = LoggerFactory.getLogger(FerramentasService.class);

    public FerramentasService(FerramentasReposity ferramentasRepository) {
        this.ferramentasRepository = ferramentasRepository;
    }

    public Ferramentas obterFerramentasPorId(Long id) {
        return ferramentasRepository.findById(id).orElse(null);
    }

    public Ferramentas criarFerramentas(Ferramentas ferramentas) {
        return ferramentasRepository.save(ferramentas);
    }

    public Ferramentas atualizarFerramentas(Ferramentas ferramentas) {
        return ferramentasRepository.save(ferramentas);
    }

    public void excluirFerramentas(Long id) {
        ferramentasRepository.deleteById(id);
    }

    
    @Transactional
    public void criarFerramentasParaPerfil(Perfil novoPerfil) {
// TEM UM ERRO QUE CERTAMENTE ESTA NA HORA DE DEFINIR O PERFIL DA FERRAMENTA

    // criar o ferramenta 
    Ferramentas ferramenta = new Ferramentas();
    ferramenta.setNomeFerramenta("test");
    ferramenta.setServicoMinimo("tet");
    // ferramenta.setPedidos(null);
    // ferramenta.setPrecificacao(null);

    logger.info("METADADOS - ferramenta: {}", ferramenta.toString());
    logger.info("METADADOS - novoPerfil: {}", novoPerfil.toString());

    Ferramentas novaFerramenta = criarFerramentas(ferramenta);

    // associá-lo ao usuário
    novoPerfil.setFerramentas(novaFerramenta);
  }
}
