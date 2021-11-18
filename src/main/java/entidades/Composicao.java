package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Composicao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long compId;

    @Column(name = "comp_nome")
    private String nome;

    @Column(name = "comp_valor")
    private BigDecimal valor = BigDecimal.ZERO;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "composicao", orphanRemoval = true)
    private List<ItemComp> itemCompList = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<ItemComp> getItemCompList() {
        return itemCompList;
    }

    public void setItemCompList(List<ItemComp> itemCompList) {
        this.itemCompList = itemCompList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composicao c = (Composicao) o;
        return Objects.equals(compId, c.compId) && Objects.equals(nome, c.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compId, nome);
    }

    public Long getId() {
        return compId;
    }
}
