package com.sbk.api.service;

import com.sbk.api.ValidationException;
import com.sbk.api.domain.agenda.AgendaDto;
import com.sbk.api.domain.agenda.AgendaEditarDadosDto;
import com.sbk.api.domain.agenda.AgendaExibirDadosDto;
import com.sbk.api.domain.agenda.AgendaModel;
import com.sbk.api.domain.cliente.ClienteModel;
import com.sbk.api.domain.corretor.CorretorModel;
import com.sbk.api.domain.imoveis.ImovelModel;
import com.sbk.api.repository.AgendaRepository;
import com.sbk.api.repository.ClienteRepository;
import com.sbk.api.repository.CorretorRepository;
import com.sbk.api.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AgendaService {
    @Autowired
    private AgendaRepository agendaRepository;
    @Autowired
    private CorretorRepository corretorRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ImovelRepository imovelRepository;

    public AgendaExibirDadosDto CriarAgenda(AgendaDto dados){
        if(!corretorRepository.existsById(dados.idCorretor())){
            throw new ValidationException("Corretor não encontrado com id passado!");
        }

        if(!imovelRepository.existsById(dados.idImovel())){
            throw new ValidationException("Imovel não encontrado com id passado!");
        }

        if(!clienteRepository.existsById(dados.idCliente())){
            throw  new ValidationException("Cliente não encontrado com id passado!");
        }

        var corretor = corretorRepository.getReferenceById(dados.idCorretor());
        var cliente = clienteRepository.getReferenceById(dados.idCliente());
        var imovel = imovelRepository.getReferenceById(dados.idImovel());

        var agenda = new AgendaModel(corretor, cliente, imovel, dados);
        agendaRepository.save(agenda);

        return new AgendaExibirDadosDto(agenda);
    }

    public Page<AgendaExibirDadosDto> ListarAgendas(Pageable pageable){
        var page = agendaRepository.findAll(pageable).map(AgendaExibirDadosDto::new);

        return page;
    }

    public AgendaExibirDadosDto ExibirDadosAgenda(Long id){
        var agenda = agendaRepository.getReferenceById(id);

        return new AgendaExibirDadosDto(agenda);
    }

    public AgendaExibirDadosDto EditarDadosAgenda(Long id, AgendaEditarDadosDto dados){
        var agenda = agendaRepository.getReferenceById(id);
        CorretorModel corretor = null;
        ImovelModel imovel = null;
        ClienteModel cliente = null;
        if(dados.idImovel() != null){
            if (!imovelRepository.existsById(dados.idImovel())) {
                throw new ValidationException("Imovel não encontrado com id passado!");
            }
            imovel = imovelRepository.getReferenceById(dados.idImovel());
        }

        if(dados.idCorretor() != null){
            if (!corretorRepository.existsById(dados.idCorretor())) {
                throw new ValidationException("Corretor não encontrado com id passado!");
            }
            corretor = corretorRepository.getReferenceById(dados.idCorretor());
        }

        if(dados.idCliente() != null){
            if (!clienteRepository.existsById(dados.idCliente())) {
                throw new ValidationException("Cliente não encontrado com id passado!");
            }
            cliente = clienteRepository.getReferenceById(dados.idCliente());
        }

        if(imovel != null && cliente != null && corretor != null) {
            agenda.EditarDados(corretor, cliente, imovel, dados);
        } else if (imovel != null && cliente != null && corretor == null) {
            agenda.EditarDados(null, cliente, imovel, dados);
        } else if (imovel != null && cliente == null && corretor != null) {
            agenda.EditarDados(corretor, null, imovel, dados);
        } else if (imovel == null && cliente != null && corretor != null) {
            agenda.EditarDados(corretor, cliente, null, dados);
        } else if (imovel != null && cliente == null && corretor == null) {
            agenda.EditarDados(null, null, imovel, dados);
        } else if (imovel == null && cliente != null && corretor == null) {
            agenda.EditarDados(null, cliente, null, dados);
        } else if (imovel == null && cliente == null && corretor != null) {
            agenda.EditarDados(corretor, null, null, dados);
        }else {
            agenda.EditarDados(null, null, null, dados);
        }

        return new AgendaExibirDadosDto(agenda);
    }

    public void ExcluirAgenda(Long id){
        var agenda = agendaRepository.getReferenceById(id);
        agendaRepository.delete(agenda);
    }

}
