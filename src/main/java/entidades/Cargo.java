package entidades;

import ENUM.TipoPessoa;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
public class Cargo implements Serializable, ClassePai {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cargoId;

    @Column(name = "cargo_desc")
    private String cargoDesc;

    @Column(name = "cargo_salario")
    private BigDecimal cargoSalario;

    @Column(name = "cargo_ativo")
    private Boolean cargoAtivo;

    public String getCargoDesc() { return cargoDesc; }

    public void setCargoDesc(String cargoDesc) { this.cargoDesc = cargoDesc; }

    public BigDecimal getCargoSalario() { return cargoSalario; }

    public void setCargoSalario(BigDecimal cargoSalario) { this.cargoSalario = cargoSalario; }

    public Boolean getCargoAtivo() { return cargoAtivo; }

    public void setCargoAtivo(Boolean cargoAtivo) { this.cargoAtivo = cargoAtivo; }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return Objects.equals(cargoId, cargo.cargoId) && Objects.equals(cargoDesc, cargo.cargoDesc) && Objects.equals(cargoSalario, cargo.cargoSalario) && Objects.equals(cargoAtivo, cargo.cargoAtivo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cargoId, cargoDesc, cargoSalario, cargoAtivo);
    }

    @Override
    public Long getId() {
        return cargoId;
    }

    public void setCargoId(Long cargoId) {
        this.cargoId = cargoId;
    }
}
