package entidades;

import ENUM.TipoPlanoPagamento;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class PlanoPagamento implements Serializable, ClassePai {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long planoId;

    @Column(name = "plano_nome")
    private String planoNome;

    @Column(name = "planto_tipo")
    private TipoPlanoPagamento planoTipo;

    @Column(name = "plano_ativo")
    private Boolean planoAtivo = true;


    public String getPlanoNome() { return planoNome; }

    public void setPlanoNome(String planoNome) { this.planoNome = planoNome; }

    public TipoPlanoPagamento getPlanoTipo() { return planoTipo; }

    public void setPlanoTipo(TipoPlanoPagamento planoTipo) { this.planoTipo = planoTipo; }

    public Boolean getPlanoAtivo() { return planoAtivo; }

    public void setPlanoAtivo(Boolean planoAtivo) { this.planoAtivo = planoAtivo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanoPagamento that = (PlanoPagamento) o;
        return Objects.equals(planoId, that.planoId) && Objects.equals(planoNome, that.planoNome) && planoTipo == that.planoTipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(planoId, planoNome, planoTipo);
    }

    @Override
    public Long getId() {
        return planoId;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
