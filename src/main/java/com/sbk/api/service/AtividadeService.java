package com.sbk.api.service;

import com.sbk.api.ValidationException;
import com.sbk.api.domain.atividade.AtividadeDto;
import com.sbk.api.domain.atividade.AtividadeEditarDadosDto;
import com.sbk.api.domain.atividade.AtividadeExibirDadosDto;
import com.sbk.api.domain.atividade.AtividadeModel;
import com.sbk.api.domain.cliente.ClienteModel;
import com.sbk.api.domain.imoveis.ImovelModel;
import com.sbk.api.repository.AtividadeRepository;
import com.sbk.api.repository.ClienteRepository;
import com.sbk.api.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AtividadeService {
    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private ImovelRepository imovelRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public AtividadeExibirDadosDto criarAtividade(AtividadeDto dados){
        if(!imovelRepository.existsById(dados.idImovel())){
            throw new ValidationException("Imovel não encontrado com id passado!");
        }

        if(!clienteRepository.existsById(dados.idCliente())){
            throw  new ValidationException("Cliente não encontrado com id passado!");
        }

        var imovel = imovelRepository.getReferenceById(dados.idImovel());
        var cliente = clienteRepository.getReferenceById(dados.idCliente());

        var atividade = new AtividadeModel(imovel, cliente, dados);
        atividadeRepository.save(atividade);

        return new AtividadeExibirDadosDto(atividade);
    }

    public Page<AtividadeExibirDadosDto> listarAtividades(Pageable pageable){
        var page = atividadeRepository.findAll(pageable).map(AtividadeExibirDadosDto::new);

        return page;
    }

    public AtividadeExibirDadosDto exibirDadosAtividade(Long id){
        var atividade = atividadeRepository.getReferenceById(id);

        return new AtividadeExibirDadosDto(atividade);
    }

    public AtividadeExibirDadosDto editarDadosAtividade(Long id, AtividadeEditarDadosDto dados){
        var atividade = atividadeRepository.getReferenceById(id);
        ImovelModel imovel = null;
        ClienteModel cliente = null;
        if(dados.idImovel() != null){
            if (!imovelRepository.existsById(dados.idImovel())) {
                throw new ValidationException("Imovel não encontrado com id passado!");
            }
            imovel = imovelRepository.getReferenceById(dados.idImovel());
        }

        if(dados.idCliente() != null){
            if (!clienteRepository.existsById(dados.idCliente())) {
                throw new ValidationException("Cliente não encontrado com id passado!");
            }
            cliente = clienteRepository.getReferenceById(dados.idCliente());
        }

        if(imovel != null && cliente != null) {
            atividade.EditarDados(imovel, cliente, dados);
        } else if (imovel != null && cliente == null) {
            atividade.EditarDados(imovel, null, dados);
        } else if (imovel == null && cliente != null) {
            atividade.EditarDados(null, cliente, dados);
        }else {
            atividade.EditarDados(null, null, dados);
        }

        return new AtividadeExibirDadosDto(atividade);
    }

    public void excluirAtividade(Long id){
        var atividade = atividadeRepository.getReferenceById(id);
        atividadeRepository.delete(atividade);
    }
}
