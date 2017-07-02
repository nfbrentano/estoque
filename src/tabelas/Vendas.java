/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Natanael
 */
@Entity
@Table(name = "vendas")

public class Vendas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvendas")
    private Integer idvendas;

    @Column(name = "nomerazaosocial")
    private String nomerazaosocial;

    @Column(name = "documento")
    private String documento;

    @Column(name = "modelo_idmodelo")
    private int modelo_idmodelo;

    @Column(name = "quantidade_quantidademodelo")
    private int quantidade_quantidademodelo;

    @Column(name = "valorvenda")
    private Double valorvenda;

    @Column(name = "disponibilidade")
    private boolean disponibilidade;
    
    public Vendas() {

    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Integer getIdvendas() {
        return idvendas;
    }

    public void setIdvendas(Integer idvendas) {
        this.idvendas = idvendas;
    }

    public String getNomerazaosocial() {
        return nomerazaosocial;
    }

    public void setNomerazaosocial(String nomerazaosocial) {
        this.nomerazaosocial = nomerazaosocial;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getModelo_idmodelo() {
        return modelo_idmodelo;
    }

    public void setModelo_idmodelo(int modelo_idmodelo) {
        this.modelo_idmodelo = modelo_idmodelo;
    }

    public int getQuantidade_quantidademodelo() {
        return quantidade_quantidademodelo;
    }

    public void setQuantidade_quantidademodelo(int quantidade_quantidademodelo) {
        this.quantidade_quantidademodelo = quantidade_quantidademodelo;
    }

    public Double getValorvenda() {
        return valorvenda;
    }

    public void setValorvenda(Double valorvenda) {
        this.valorvenda = valorvenda;
    }

    

   

  }
