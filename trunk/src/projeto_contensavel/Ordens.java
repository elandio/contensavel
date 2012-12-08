/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projeto_contensavel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author renata
 */
@Entity
@Table(name = "ordens", catalog = "bd_contensavel", schema = "")
@NamedQueries({
    @NamedQuery(name = "Ordens.findAll", query = "SELECT o FROM Ordens o"),
    @NamedQuery(name = "Ordens.findByCodOrdem", query = "SELECT o FROM Ordens o WHERE o.codOrdem = :codOrdem"),
    @NamedQuery(name = "Ordens.findByCodFilial", query = "SELECT o FROM Ordens o WHERE o.codFilial = :codFilial"),
    @NamedQuery(name = "Ordens.findByCodFuncionario", query = "SELECT o FROM Ordens o WHERE o.codFuncionario = :codFuncionario"),
    @NamedQuery(name = "Ordens.findByTipoOrdem", query = "SELECT o FROM Ordens o WHERE o.tipoOrdem = :tipoOrdem"),
    @NamedQuery(name = "Ordens.findByNumCarro", query = "SELECT o FROM Ordens o WHERE o.numCarro = :numCarro"),
    @NamedQuery(name = "Ordens.findByKm", query = "SELECT o FROM Ordens o WHERE o.km = :km"),
    @NamedQuery(name = "Ordens.findByHorario", query = "SELECT o FROM Ordens o WHERE o.horario = :horario"),
    @NamedQuery(name = "Ordens.findByDataLanc", query = "SELECT o FROM Ordens o WHERE o.dataLanc = :dataLanc"),
    @NamedQuery(name = "Ordens.findByOrigem", query = "SELECT o FROM Ordens o WHERE o.origem = :origem"),
    @NamedQuery(name = "Ordens.findByDestino", query = "SELECT o FROM Ordens o WHERE o.destino = :destino")})
public class Ordens implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_ordem")
    private Integer codOrdem;
    @JoinColumn(name="cod_filial",referencedColumnName="cod_filial")
    @ManyToOne
    private Filiais codFilial;
    @JoinColumn(name="cod_funcionario",referencedColumnName="cod_funcionario")
    @ManyToOne
    private Funcionarios codFuncionario;
    @Basic(optional = false)
    @Column(name = "tipo_ordem")
    private String tipoOrdem;
    @Column(name = "num_carro")
    private Integer numCarro;
    @Column(name = "km")
    private Integer km;
    @Column(name = "horario")
    @Temporal(TemporalType.TIME)
    private Date horario;
    @Column(name = "data_lanc")
    @Temporal(TemporalType.DATE)
    private Date dataLanc;
    @Basic(optional = false)
    @Column(name = "origem")
    private String origem;
    @Basic(optional = false)
    @Column(name = "destino")
    private String destino;

    public Ordens() {
    }

    public Ordens(Integer codOrdem) {
        this.codOrdem = codOrdem;
    }

    public Ordens(Integer codOrdem, Filiais codFilial, Funcionarios codFuncionario, String tipoOrdem, String origem, String destino) {
        this.codOrdem = codOrdem;
        this.codFilial = codFilial;
        this.codFuncionario = codFuncionario;
        this.tipoOrdem = tipoOrdem;
        this.origem = origem;
        this.destino = destino;
    }

    public Integer getCodOrdem() {
        return codOrdem;
    }

    public void setCodOrdem(Integer codOrdem) {
        Integer oldCodOrdem = this.codOrdem;
        this.codOrdem = codOrdem;
        changeSupport.firePropertyChange("codOrdem", oldCodOrdem, codOrdem);
    }

    public Filiais getCodFilial() {
        return codFilial;
    }

    public void setCodFilial(Filiais codFilial) {
        Filiais oldCodFilial = this.codFilial;
        this.codFilial = codFilial;
        changeSupport.firePropertyChange("codFilial", oldCodFilial, codFilial);
    }

    public Funcionarios getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(Funcionarios codFuncionario) {
        Funcionarios oldCodFuncionario = this.codFuncionario;
        this.codFuncionario = codFuncionario;
        changeSupport.firePropertyChange("codFuncionario", oldCodFuncionario, codFuncionario);
    }

    public String getTipoOrdem() {
        return tipoOrdem;
    }

    public void setTipoOrdem(String tipoOrdem) {
        String oldTipoOrdem = this.tipoOrdem;
        this.tipoOrdem = tipoOrdem;
        changeSupport.firePropertyChange("tipoOrdem", oldTipoOrdem, tipoOrdem);
    }

    public Integer getNumCarro() {
        return numCarro;
    }

    public void setNumCarro(Integer numCarro) {
        Integer oldNumCarro = this.numCarro;
        this.numCarro = numCarro;
        changeSupport.firePropertyChange("numCarro", oldNumCarro, numCarro);
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        Integer oldKm = this.km;
        this.km = km;
        changeSupport.firePropertyChange("km", oldKm, km);
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        Date oldHorario = this.horario;
        this.horario = horario;
        changeSupport.firePropertyChange("horario", oldHorario, horario);
    }

    public Date getDataLanc() {
        return dataLanc;
    }

    public void setDataLanc(Date dataLanc) {
        Date oldDataLanc = this.dataLanc;
        this.dataLanc = dataLanc;
        changeSupport.firePropertyChange("dataLanc", oldDataLanc, dataLanc);
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        String oldOrigem = this.origem;
        this.origem = origem;
        changeSupport.firePropertyChange("origem", oldOrigem, origem);
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        String oldDestino = this.destino;
        this.destino = destino;
        changeSupport.firePropertyChange("destino", oldDestino, destino);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codOrdem != null ? codOrdem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordens)) {
            return false;
        }
        Ordens other = (Ordens) object;
        if ((this.codOrdem == null && other.codOrdem != null) || (this.codOrdem != null && !this.codOrdem.equals(other.codOrdem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projeto_contensavel.Ordens[codOrdem=" + codOrdem + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
