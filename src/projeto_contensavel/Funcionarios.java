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
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "funcionarios", catalog = "bd_contensavel", schema = "")
@NamedQueries({
    @NamedQuery(name = "Funcionarios.findAll", query = "SELECT f FROM Funcionarios f"),
    @NamedQuery(name = "Funcionarios.findByCodFuncionario", query = "SELECT f FROM Funcionarios f WHERE f.codFuncionario = :codFuncionario"),
    @NamedQuery(name = "Funcionarios.findByCodFuncao", query = "SELECT f FROM Funcionarios f WHERE f.codFuncao = :codFuncao"),
    @NamedQuery(name = "Funcionarios.findByMatricula", query = "SELECT f FROM Funcionarios f WHERE f.matricula = :matricula"),
    @NamedQuery(name = "Funcionarios.findByNome", query = "SELECT f FROM Funcionarios f WHERE f.nome = :nome"),
    @NamedQuery(name = "Funcionarios.findByRua", query = "SELECT f FROM Funcionarios f WHERE f.rua = :rua"),
    @NamedQuery(name = "Funcionarios.findByBairro", query = "SELECT f FROM Funcionarios f WHERE f.bairro = :bairro"),
    @NamedQuery(name = "Funcionarios.findByCidade", query = "SELECT f FROM Funcionarios f WHERE f.cidade = :cidade"),
    @NamedQuery(name = "Funcionarios.findByEstado", query = "SELECT f FROM Funcionarios f WHERE f.estado = :estado"),
    @NamedQuery(name = "Funcionarios.findByCep", query = "SELECT f FROM Funcionarios f WHERE f.cep = :cep"),
    @NamedQuery(name = "Funcionarios.findByCpf", query = "SELECT f FROM Funcionarios f WHERE f.cpf = :cpf")})
public class Funcionarios implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_funcionario")
    private Integer codFuncionario;
    @JoinColumn(name="cod_funcao",referencedColumnName="cod_funcao")
    @ManyToOne(optional = false)
    private Funcoes codFuncao;
    @Column(name = "matricula")
    private Integer matricula;
    @Column(name = "nome")
    private String nome;
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
    @Column(name = "cpf")
    private Integer cpf;
    @OneToMany(mappedBy = "codFuncionario")
    private List<Ordens> ordensList;

    public Funcionarios() {
    }

    public Funcionarios(Integer codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public Funcionarios(Integer codFuncionario, Funcoes codFuncao) {
        this.codFuncionario = codFuncionario;
        this.codFuncao = codFuncao;
    }

    public Integer getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(Integer codFuncionario) {
        Integer oldCodFuncionario = this.codFuncionario;
        this.codFuncionario = codFuncionario;
        changeSupport.firePropertyChange("codFuncionario", oldCodFuncionario, codFuncionario);
    }

    public Funcoes getCodFuncao() {
        return codFuncao;
    }

    public void setCodFuncao(Funcoes codFuncao) {
        Funcoes oldCodFuncao = this.codFuncao;
        this.codFuncao = codFuncao;
        changeSupport.firePropertyChange("codFuncao", oldCodFuncao, codFuncao);
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        Integer oldMatricula = this.matricula;
        this.matricula = matricula;
        changeSupport.firePropertyChange("matricula", oldMatricula, matricula);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
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

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        Integer oldCpf = this.cpf;
        this.cpf = cpf;
        changeSupport.firePropertyChange("cpf", oldCpf, cpf);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFuncionario != null ? codFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionarios)) {
            return false;
        }
        Funcionarios other = (Funcionarios) object;
        if ((this.codFuncionario == null && other.codFuncionario != null) || (this.codFuncionario != null && !this.codFuncionario.equals(other.codFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projeto_contensavel.Funcionarios[codFuncionario=" + codFuncionario + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
