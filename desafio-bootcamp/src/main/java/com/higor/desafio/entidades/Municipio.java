package com.higor.desafio.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "TB_MUNICIPIO")
public class Municipio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MUNICIPIO_SEQ")
    @SequenceGenerator(name = "MUNICIPIO_SEQ", sequenceName = "SEQUENCE_MUNICIPIO", allocationSize = 1)
    private Long codigoMunicipio;

    @ManyToOne
    @JoinColumn(name = "codigoUF")
    private UF uf;

    private String nome;
    private int status;

    public Long getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public UF getUf() {
        return uf;
    }

    public String getNome() {
        return nome;
    }

    public int getStatus() {
        return status;
    }

    public void setCodigoMunicipio(Long codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
}

