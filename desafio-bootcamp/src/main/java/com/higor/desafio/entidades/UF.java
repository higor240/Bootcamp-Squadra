package com.higor.desafio.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_UF")
public class UF {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UF_SEQ")
    @SequenceGenerator(name = "UF_SEQ", sequenceName = "SEQUENCE_UF", allocationSize = 1)
    private Long codigoUF;

    private String sigla;
    private String nome;
    private int status;

    public Long getCodigoUF() {
        return codigoUF;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }

    public int getStatus() {
        return status;
    }

    public void setCodigoUF(Long codigoUF) {
        this.codigoUF = codigoUF;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
}
