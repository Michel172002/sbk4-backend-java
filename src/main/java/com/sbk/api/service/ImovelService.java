package com.sbk.api.service;

import com.sbk.api.ValidationException;
import com.sbk.api.domain.imoveis.ImovelDto;
import com.sbk.api.domain.imoveis.ImovelEditarDadosDto;
import com.sbk.api.domain.imoveis.ImovelExibirDadosDto;
import com.sbk.api.domain.imoveis.ImovelModel;
import com.sbk.api.repository.ImovelRepository;
import com.sbk.api.repository.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ImovelService {
    @Autowired
    private ImovelRepository imovelRepository;

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    public ImovelExibirDadosDto criarImovel(ImovelDto dados){
        if(!proprietarioRepository.existsById(dados.idProp())){
            throw new ValidationException("Proprietario não encontrado com o id passado!");
        }
        var proprietario = proprietarioRepository.getReferenceById(dados.idProp());

        var imovel = new ImovelModel(proprietario, dados);
        imovelRepository.save(imovel);

        return new ImovelExibirDadosDto(imovel);
    }

    public Page<ImovelExibirDadosDto> listarImoveis(Pageable pageable){
        var page = imovelRepository.findAll(pageable).map(ImovelExibirDadosDto::new);

        return page;
    }

    public ImovelExibirDadosDto exibirDadosImovel(Long id){
        var imovel = imovelRepository.getReferenceById(id);

        return new ImovelExibirDadosDto(imovel);
    }

    public ImovelExibirDadosDto editarDadosImovel(Long id, ImovelEditarDadosDto dados){
        var imovel = imovelRepository.getReferenceById(id);

        if(dados.idProp() != null){
            if(!proprietarioRepository.existsById(dados.idProp())){
                throw new ValidationException("Proprietario não encontrado com o id passado!");
            }
            var prop = proprietarioRepository.getReferenceById(dados.idProp());
            imovel.EditarDados(prop, dados);
        }else {
            imovel.EditarDados(null, dados);
        }

        return new ImovelExibirDadosDto(imovel);
    }

    public void excluirImovel(Long id){
        var imovel = imovelRepository.getReferenceById(id);
        imovelRepository.delete(imovel);
    }
}
