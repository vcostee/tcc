package entidades;

import ENUM.TipoPessoa;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pesId;

    @Column(name = "pes_nome")
    private String pesNome;

    @Column(name = "pes_rg")
    private String pesRg;

    @Column(name = "pes_cpf")
    private String pesCpf;

    @Column(name = "pes_cnpj")
    private String pesCnpj;

    @Column(name = "pes_nasc")
    @Temporal(TemporalType.DATE)
    private Date pesDataNascimento;

    @Column(name = "pes_admissao")
    @Temporal(TemporalType.DATE)
    private Date pesDataAdm;

    @Column(name = "pes_salario")
    private BigDecimal pesSalario;

    @Column(name = "pes_funcionario")
    private Boolean pesFuncionario;

    @Column(name = "pes_fornecedor")
    private Boolean pesFornecedor;

    @Column(name = "pes_tipo")
    private TipoPessoa pesTipo;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;


    // Gets e Sets

    public String getPesNome() { return pesNome; }

    public void setPesNome(String pesNome) { this.pesNome = pesNome; }

    public String getPesRg() { return pesRg; }

    public void setPesRg(String pesRg) { this.pesRg = pesRg; }

    public String getPesCpf() { return pesCpf; }

    public void setPesCpf(String pesCpf) { this.pesCpf = pesCpf; }

    public Date getPesDataNascimento() { return pesDataNascimento; }

    public void setPesDataNascimento(Date pesDataNascimento) { this.pesDataNascimento = pesDataNascimento; }

    public BigDecimal getPesSalario() { return pesSalario; }

    public void setPesSalario(BigDecimal pesSalario) { this.pesSalario = pesSalario; }

    public String getPesCnpj() { return pesCnpj; }

    public void setPesCnpj(String pesCnpj) { this.pesCnpj = pesCnpj; }

    public Date getPesDataAdm() { return pesDataAdm; }

    public void setPesDataAdm(Date pesDataAdm) { this.pesDataAdm = pesDataAdm; }

    public Boolean getPesFuncionario() { return pesFuncionario; }

    public void setPesFuncionario(Boolean pesFuncionario) { this.pesFuncionario = pesFuncionario; }

    public Boolean getPesFornecedor() { return pesFornecedor; }

    public void setPesFornecedor(Boolean pesFornecedor) { this.pesFornecedor = pesFornecedor; }

    public TipoPessoa getPesTipo() { return pesTipo; }

    public void setPesTipo(TipoPessoa pesTipo) { this.pesTipo = pesTipo; }

    public Cargo getCargo() { return cargo; }

    public void setCargo(Cargo cargo) { this.cargo = cargo; }


    @Override
    public String toString() {
        return pesId.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(pesId, pessoa.pesId) && Objects.equals(pesNome, pessoa.pesNome) && Objects.equals(pesRg, pessoa.pesRg) && Objects.equals(pesCpf, pessoa.pesCpf) && Objects.equals(pesDataNascimento, pessoa.pesDataNascimento) && Objects.equals(pesSalario, pessoa.pesSalario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pesId, pesNome, pesRg, pesCpf, pesDataNascimento, pesSalario);
    }

    public Long getId() {
        return pesId;
    }

    public void setPesId(Long pesId) {
        this.pesId = pesId;
    }
}
