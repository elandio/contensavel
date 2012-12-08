/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projeto_contensavel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author renata
 */
@Entity
@Table(name = "filiais", catalog = "bd_contensavel", schema = "")
@NamedQueries({
    @NamedQuery(name = "Filiais.findAll", query = "SELECT f FROM Filiais f"),
    @NamedQuery(name = "Filiais.findByCodFilial", query = "SELECT f FROM Filiais f WHERE f.codFilial = :codFilial"),
    @NamedQuery(name = "Filiais.findByRazaoSocial", query = "SELECT f FROM Filiais f WHERE f.razaoSocial = :razaoSocial"),
    @NamedQuery(name = "Filiais.findByCnpj", query = "SELECT f FROM Filiais f WHERE f.cnpj = :cnpj"),
    @NamedQuery(name = "Filiais.findByRua", query = "SELECT f FROM Filiais f WHERE f.rua = :rua"),
    @NamedQuery(name = "Filiais.findByBairro", query = "SELECT f FROM Filiais f WHERE f.bairro = :bairro"),
    @NamedQuery(name = "Filiais.findByCidade", query = "SELECT f FROM Filiais f WHERE f.cidade = :cidade"),
    @NamedQuery(name = "Filiais.findByEstado", query = "SELECT f FROM Filiais f WHERE f.estado = :estado"),
    @NamedQuery(name = "Filiais.findByCep", query = "SELECT f FROM Filiais f WHERE f.cep = :cep")})
public class Filiais implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_filial")
    private Integer codFilial;
    @Column(name = "razao_social")
    private String razaoSocial;
    @Column(name = "cnpj")
    private Integer cnpj;
    @Column(name = "rua")
    private String rua;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "estado")
    private String estado;
    @Column(name = "cep")
    private Integer cep;
    @OneToMany(mappedBy = "codFilial")
    private List<Ordens> ordensList;

    public Filiais() {
    }

    public Filiais(Integer codFilial) {
        this.codFilial = codFilial;
    }

    public Integer getCodFilial() {
        return codFilial;
    }

    public void setCodFilial(Integer codFilial) {
        Integer oldCodFilial = this.codFilial;
        this.codFilial = codFilial;
        changeSupport.firePropertyChange("codFilial", oldCodFilial, codFilial);
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        String oldRazaoSocial = this.razaoSocial;
        this.razaoSocial = razaoSocial;
        changeSupport.firePropertyChange("razaoSocial", oldRazaoSocial, razaoSocial);
    }

    public Integer getCnpj() {
        return cnpj;
    }

    public void setCnpj(Integer cnpj) {
        Integer oldCnpj = this.cnpj;
        this.cnpj = cnpj;
        changeSupport.firePropertyChange("cnpj", oldCnpj, cnpj);
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        String oldRua = this.rua;
        this.rua = rua;
        changeSupport.firePropertyChange("rua", oldRua, rua);
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        String oldBairro = this.bairro;
        this.bairro = bairro;
        changeSupport.firePropertyChange("bairro", oldBairro, bairro);
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        String oldCidade = this.cidade;
        this.cidade = cidade;
        changeSupport.firePropertyChange("cidade", oldCidade, cidade);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        String oldEstado = this.estado;
        this.estado = estado;
        changeSupport.firePropertyChange("estado", oldEstado, estado);
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        Integer oldCep = this.cep;
        this.cep = cep;
        changeSupport.firePropertyChange("cep", oldCep, cep);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFilial != null ? codFilial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filiais)) {
            return false;
        }
        Filiais other = (Filiais) object;
        if ((this.codFilial == null && other.codFilial != null) || (this.codFilial != null && !this.codFilial.equals(other.codFilial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projeto_contensavel.Filiais[codFilial=" + codFilial + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
