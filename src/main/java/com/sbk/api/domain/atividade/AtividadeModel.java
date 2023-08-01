package com.sbk.api.domain.atividade;

import com.sbk.api.domain.cliente.ClienteModel;
import com.sbk.api.domain.imoveis.ImovelModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "atividades")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AtividadeModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idImovel")
    private ImovelModel imovel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente")
    private ClienteModel cliente;

    private Boolean ativo;

    private int vencimento;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    private LocalDateTime createAt;

    private LocalDateTime lastUpdate;
}
