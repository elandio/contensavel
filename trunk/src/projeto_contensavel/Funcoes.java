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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "funcoes", catalog = "bd_contensavel", schema = "")
@NamedQueries({
    @NamedQuery(name = "Funcoes.findAll", query = "SELECT f FROM Funcoes f"),
    @NamedQuery(name = "Funcoes.findByCodFuncao", query = "SELECT f FROM Funcoes f WHERE f.codFuncao = :codFuncao"),
    @NamedQuery(name = "Funcoes.findByFuncao", query = "SELECT f FROM Funcoes f WHERE f.funcao = :funcao")})
public class Funcoes implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_funcao")
    private Integer codFuncao;
    @Column(name = "funcao")
    private String funcao;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "codFuncao")
    private List<Funcionarios> funcionariosList;

    public Funcoes() {
    }

    public Funcoes(Integer codFuncao) {
        this.codFuncao = codFuncao;
    }

    public Integer getCodFuncao() {
        return codFuncao;
    }

    public void setCodFuncao(Integer codFuncao) {
        Integer oldCodFuncao = this.codFuncao;
        this.codFuncao = codFuncao;
        changeSupport.firePropertyChange("codFuncao", oldCodFuncao, codFuncao);
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        String oldFuncao = this.funcao;
        this.funcao = funcao;
        changeSupport.firePropertyChange("funcao", oldFuncao, funcao);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFuncao != null ? codFuncao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcoes)) {
            return false;
        }
        Funcoes other = (Funcoes) object;
        if ((this.codFuncao == null && other.codFuncao != null) || (this.codFuncao != null && !this.codFuncao.equals(other.codFuncao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projeto_contensavel.Funcoes[codFuncao=" + codFuncao + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
