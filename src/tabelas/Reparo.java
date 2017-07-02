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
@Table(name = "reparo")

public class Reparo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreparos")
    private Integer idreparos;

    @Column(name = "datareparo")
    private String datareparo;

    @Column(name = "modelo_idmodelo")
    private int modelo_idmodelo;

    @Column(name = "valorreparo")
    private double valorreparo;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "funcionarios_idfuncionarios")
    private int funcionarios_idfuncionarios;

    @Column(name = "fabricantes_idfabricantes")
    private int fabricantes_idfabricantes;

    @Column(name = "disponibilidade")
    private boolean disponibilidade;

    public Reparo() {

    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Integer getIdreparos() {
        return idreparos;
    }

    public void setIdreparos(Integer idreparos) {
        this.idreparos = idreparos;
    }

    public String getDatareparo() {
        return datareparo;
    }

    public void setDatareparo(String datareparo) {
        this.datareparo = datareparo;
    }

    public int getModelo_idmodelo() {
        return modelo_idmodelo;
    }

    public void setModelo_idmodelo(int modelo_idmodelo) {
        this.modelo_idmodelo = modelo_idmodelo;
    }

    public double getValorreparo() {
        return valorreparo;
    }

    public void setValorreparo(double valorreparo) {
        this.valorreparo = valorreparo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getFuncionarios_idfuncionarios() {
        return funcionarios_idfuncionarios;
    }

    public void setFuncionarios_idfuncionarios(int funcionarios_idfuncionarios) {
        this.funcionarios_idfuncionarios = funcionarios_idfuncionarios;
    }

    public int getFabricantes_idfabricantes() {
        return fabricantes_idfabricantes;
    }

    public void setFabricantes_idfabricantes(int fabricantes_idfabricantes) {
        this.fabricantes_idfabricantes = fabricantes_idfabricantes;
    }
}
