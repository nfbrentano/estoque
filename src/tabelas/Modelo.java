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
@Table(name = "modelo")

public class Modelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmodelo")
    private Integer idmodelo;

    @Column(name = "nome")
    private String nome;

    @Column(name = "valorcompra")
    private double valorcompra;

    @Column(name = "quantidade")
    private int quantidade;

   
    
    @Column(name = "tipoproduto_idtipoproduto")
    private String tipoproduto_idtipoproduto;

    @Column(name = "fabricantes_idfabricantes")
    private String fabricantes_idfabricantes;

    @Column(name = "disponibilidade")
    private boolean disponibilidade;

    public Modelo() {

    }

    public Integer getIdmodelo() {
        return idmodelo;
    }

    public void setIdmodelo(Integer idmodelo) {
        this.idmodelo = idmodelo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(double valorcompra) {
        this.valorcompra = valorcompra;
    }

  

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

   
    public String getTipoproduto_idtipoproduto() {
        return tipoproduto_idtipoproduto;
    }

    public void setTipoproduto_idtipoproduto(String tipoproduto_idtipoproduto) {
        this.tipoproduto_idtipoproduto = tipoproduto_idtipoproduto;
    }

    public String getFabricantes_idfabricantes() {
        return fabricantes_idfabricantes;
    }

    public void setFabricantes_idfabricantes(String fabricantes_idfabricantes) {
        this.fabricantes_idfabricantes = fabricantes_idfabricantes;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    

}
