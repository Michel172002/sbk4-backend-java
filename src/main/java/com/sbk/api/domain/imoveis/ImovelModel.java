package com.sbk.api.domain.imoveis;

import com.sbk.api.domain.proprietario.ProprietarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "imoveis")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ImovelModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prop")
    private ProprietarioModel proprietario;

    private String tipo;

    private Double preco;

    private Boolean alugando;

    private Boolean financia;

    private String area;

    private String rua;

    private String bairro;

    private String cidade;

    private String numero;

    private String complemento;

    private String estado;

    private String cep;

    private String comodos;

    private String descricao;

    private LocalDateTime createAt;

    private LocalDateTime lastUpdate;
}
