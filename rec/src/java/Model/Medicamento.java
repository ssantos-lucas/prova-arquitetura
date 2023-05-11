/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lucas.ssantos154
 */
@Entity
@Table(name = "medicamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicamento.findAll", query = "SELECT m FROM Medicamento m"),
    @NamedQuery(name = "Medicamento.findById", query = "SELECT m FROM Medicamento m WHERE m.id = :id"),
    @NamedQuery(name = "Medicamento.findByNome", query = "SELECT m FROM Medicamento m WHERE m.nome = :nome"),
    @NamedQuery(name = "Medicamento.findByTipo", query = "SELECT m FROM Medicamento m WHERE m.tipo = :tipo"),
    @NamedQuery(name = "Medicamento.findByComposicao", query = "SELECT m FROM Medicamento m WHERE m.composicao = :composicao"),
    @NamedQuery(name = "Medicamento.findByPosologia", query = "SELECT m FROM Medicamento m WHERE m.posologia = :posologia"),
    @NamedQuery(name = "Medicamento.findByDosagem", query = "SELECT m FROM Medicamento m WHERE m.dosagem = :dosagem"),
    @NamedQuery(name = "Medicamento.findByMedidaDosagem", query = "SELECT m FROM Medicamento m WHERE m.medidaDosagem = :medidaDosagem"),
    @NamedQuery(name = "Medicamento.findByPreco", query = "SELECT m FROM Medicamento m WHERE m.preco = :preco")})
public class Medicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "composicao")
    private String composicao;
    @Column(name = "posologia")
    private String posologia;
    @Column(name = "dosagem")
    private Integer dosagem;
    @Column(name = "medidaDosagem")
    private String medidaDosagem;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco")
    private Double preco;

    public Medicamento() {
    }

    public Medicamento(Integer id) {
        this.id = id;
    }

    public Medicamento(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getComposicao() {
        return composicao;
    }

    public void setComposicao(String composicao) {
        this.composicao = composicao;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    public Integer getDosagem() {
        return dosagem;
    }

    public void setDosagem(Integer dosagem) {
        this.dosagem = dosagem;
    }

    public String getMedidaDosagem() {
        return medidaDosagem;
    }

    public void setMedidaDosagem(String medidaDosagem) {
        this.medidaDosagem = medidaDosagem;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamento)) {
            return false;
        }
        Medicamento other = (Medicamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Medicamento[ id=" + id + " ]";
    }
    
}
