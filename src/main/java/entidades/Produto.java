package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long prodId;

    @Column(name = "prod_nome")
    private String prodNome;

    @Column(name = "prod_qtd")
    private BigDecimal prodQtd;

    @Column(name = "prod_custo")
    private BigDecimal prodCusto;

    @Column(name = "prod_preco")
    private BigDecimal prodPreco;

    @Column(name = "prod_ativo")
    private Boolean prodAtivo = true;

    @ManyToOne
    @JoinColumn(name = "um_id")
    private UnidadeMedida unidadeMedida;

    public String getProdNome() { return prodNome; }

    public void setProdNome(String prodNome) { this.prodNome = prodNome; }

    public BigDecimal getProdQtd() { return prodQtd; }

    public void setProdQtd(BigDecimal prodQtd) { this.prodQtd = prodQtd; }

    public BigDecimal getProdCusto() { return prodCusto; }

    public void setProdCusto(BigDecimal prodCusto) { this.prodCusto = prodCusto; }

    public BigDecimal getProdPreco() { return prodPreco; }

    public void setProdPreco(BigDecimal prodPreco) { this.prodPreco = prodPreco; }

    public Boolean getProdAtivo() { return prodAtivo; }

    public void setProdAtivo(Boolean prodAtivo) { this.prodAtivo = prodAtivo; }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Long getId() {
        return prodId;
    }
    @Override
    public String toString() {
        return prodId.toString();
    }

}
