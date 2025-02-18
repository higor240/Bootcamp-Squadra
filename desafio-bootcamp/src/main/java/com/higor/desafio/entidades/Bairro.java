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
@Table(name = "TB_BAIRRO")
public class Bairro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BAIRRO_SEQ")
    @SequenceGenerator(name = "BAIRRO_SEQ", sequenceName = "SEQUENCE_BAIRRO", allocationSize = 1)
    private Long codigoBairro;

    @ManyToOne
    @JoinColumn(name = "codigoMunicipio")
    private Municipio municipio;

    private String nome;
    private int status;

    public Long getCodigoBairro() {
        return codigoBairro;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public String getNome() {
        return nome;
    }

    public int getStatus() {
        return status;
    }

    public void setCodigoBairro(Long codigoBairro) {
        this.codigoBairro = codigoBairro;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
}

