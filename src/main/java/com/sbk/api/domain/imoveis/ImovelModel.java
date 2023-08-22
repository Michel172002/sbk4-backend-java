package com.sbk.api.domain.imoveis;

import com.sbk.api.domain.proprietario.ProprietarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "imoveis")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ImovelModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prop")
    private ProprietarioModel proprietario;

    @Column(length = 50)
    private String tipo;

    private Double preco;

    private Boolean alugando;

    private Boolean financia;

    @Column(length = 50)
    private String area;

    private String rua;

    private String bairro;

    private String cidade;

    private String numero;

    private String complemento;

    @Column(length = 55)
    private String estado;

    @Column(length = 10)
    private String cep;

    @Column(length = 50 )
    private String comodos;

    private String descricao;

    private LocalDateTime createAt;

    private LocalDateTime lastUpdate;

    public ImovelModel(ProprietarioModel prop, ImovelDto dados){
        this.proprietario = prop;
        this.tipo = dados.tipo();
        this.preco = dados.preco();
        this.alugando = dados.alugando();
        this.financia = dados.financia();
        this.area = dados.area();
        this.rua = dados.rua();
        this.bairro = dados.bairro();
        this.cidade = dados.cidade();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.estado = dados.estado();
        this.cep = dados.cep();
        this.comodos = dados.comodos();
        this.descricao = dados.descricao();
        this.createAt = LocalDateTime.now();
        this.lastUpdate = LocalDateTime.now();
    }

    public void EditarDados(ProprietarioModel prop, ImovelEditarDadosDto dados){
        if(prop != null){
            this.proprietario = prop;
        }
        if(dados.tipo() != null){
            this.tipo = dados.tipo();
        }
        if(dados.preco() != null){
            this.preco = dados.preco();
        }
        if(dados.alugando() != null){
            this.alugando = dados.alugando();
        }
        if(dados.financia() != null){
            this.financia = dados.financia();
        }
        if(dados.area() != null){
            this.area = dados.area();
        }
        if(dados.rua() != null){
            this.rua = dados.rua();
        }
        if(dados.bairro() != null){
            this.bairro = dados.bairro();
        }
        if(dados.cidade() != null){
            this.cidade = dados.cidade();
        }
        if(dados.numero() != null){
            this.numero = dados.numero();
        }
        if(dados.complemento() != null){
            this.complemento = dados.complemento();
        }
        if(dados.estado() != null){
            this.estado = dados.estado();
        }
        if(dados.cep() != null){
            this.cep = dados.cep();
        }
        if(dados.comodos() != null){
            this.comodos = dados.comodos();
        }
        if(dados.descricao() != null){
            this.descricao = dados.descricao();
        }
        this.lastUpdate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public ProprietarioModel getProprietario() {
        return proprietario;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getPreco() {
        return preco;
    }

    public Boolean getAlugando() {
        return alugando;
    }

    public Boolean getFinancia() {
        return financia;
    }

    public String getArea() {
        return area;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public String getComodos() {
        return comodos;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }
}
