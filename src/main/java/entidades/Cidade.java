package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Cidade implements Serializable, ClassePai {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cidadeId;

    @Column(name = "cid_nome")
    private String cidadeNome;

    @ManyToOne
    @JoinColumn(name = "est_id")
    private Estado estado;

    public String getCidadeNome() { return cidadeNome; }

    public void setCidadeNome(String cidadeNome) { this.cidadeNome = cidadeNome; }

    public Estado getEstado() { return estado; }

    public void setEstado(Estado estado) { this.estado = estado; }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return Objects.equals(cidadeId, cidade.cidadeId) && Objects.equals(cidadeNome, cidade.cidadeNome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cidadeId, cidadeNome);
    }

    @Override
    public Long getId() {
        return cidadeId;
    }
}
