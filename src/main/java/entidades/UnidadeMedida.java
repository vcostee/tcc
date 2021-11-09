package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class UnidadeMedida implements Serializable, ClassePai {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long umId;

    @Column(name = "um_nome")
    private String umNome;

    @Column(name = "um_abrev")
    private String umAbrev;

    @Column(name = "um_casas")
    private BigDecimal umCasas;

    public String getUmNome() { return umNome; }

    public void setUmNome(String umNome) { this.umNome = umNome; }

    public String getUmAbrev() { return umAbrev; }

    public void setUmAbrev(String umAbrev) { this.umAbrev = umAbrev; }

    public BigDecimal getUmCasas() { return umCasas; }

    public void setUmCasas(BigDecimal umCasas) { this.umCasas = umCasas; }

    @Override
    public Long getId() {
        return umId;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
