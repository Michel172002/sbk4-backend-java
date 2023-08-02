package com.sbk.api.domain.corretor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "corretores")
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CorretorModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(length = 22)
    private String telefone;

    @Column(length = 50)
    private String creci;

    private Boolean ativo;

    private LocalDateTime createAt;

    private LocalDateTime lastUpdate;
}
