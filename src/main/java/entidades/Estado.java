package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Estado implements Serializable, ClassePai {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long estadoId;

    @Column(name = "est_nome")
    private String estadoNome;

    @Column(name = "est_uf")
    private String estadoUf;

    public String getEstadoNome() { return estadoNome; }

    public void setEstadoNome(String estadoNome) { this.estadoNome = estadoNome; }

    public String getEstadoUf() { return estadoUf; }

    public void setEstadoUf(String estadoUf) { this.estadoUf = estadoUf; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(estadoId, estado.estadoId) && Objects.equals(estadoNome, estado.estadoNome) && Objects.equals(estadoUf, estado.estadoUf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estadoId, estadoNome, estadoUf);
    }

    @Override
    public Long getId() {
        return estadoId;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
