package entidades;

import ENUM.StatusConta;
import ENUM.TipoConta;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
public class ReceberPagar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rpId;

    @Column(name = "rp_valor")
    private BigDecimal rpValor;

    @Column(name = "rp_qtd_parcelas")
    private BigDecimal rpQtdParcelas;

    @Column(name = "rp_num_parcela")
    private BigDecimal rpNumParcela;

    @Column(name = "rp_cadastro")
    @Temporal(TemporalType.DATE)
    private Date rpDataCadastro;

    @Column(name = "rp_vencimento")
    @Temporal(TemporalType.DATE)
    private Date rpDataVencimento;

    @Column(name = "rp_data_pagamento")
    @Temporal(TemporalType.DATE)
    private Date rpDataPagamento;

    @Column(name = "rp_status")
    private StatusConta rpStatus;

    @Column(name = "rp_tipo")
    private TipoConta rpTipo;

    @Column(name = "rp_obs")
    private String rpObs;

    public BigDecimal getRpValor() { return rpValor; }

    public void setRpValor(BigDecimal rpValor) { this.rpValor = rpValor; }

    public BigDecimal getRpQtdParcelas() { return rpQtdParcelas; }

    public void setRpQtdParcelas(BigDecimal rpQtdParcelas) { this.rpQtdParcelas = rpQtdParcelas; }

    public BigDecimal getRpNumParcela() { return rpNumParcela; }

    public void setRpNumParcela(BigDecimal rpNumParcela) { this.rpNumParcela = rpNumParcela; }

    public Date getRpDataCadastro() { return rpDataCadastro; }

    public void setRpDataCadastro(Date rpDataCadastro) { this.rpDataCadastro = rpDataCadastro; }

    public Date getRpDataVencimento() { return rpDataVencimento; }

    public void setRpDataVencimento(Date rpDataVencimento) { this.rpDataVencimento = rpDataVencimento; }

    public StatusConta getRpStatus() { return rpStatus; }

    public void setRpStatus(StatusConta rpStatus) { this.rpStatus = rpStatus; }

    public TipoConta getRpTipo() { return rpTipo; }

    public void setRpTipo(TipoConta rpTipo) { this.rpTipo = rpTipo; }

    public String getRpObs() { return rpObs; }

    public void setRpObs(String rpObs) { this.rpObs = rpObs; }

    public Date getRpDataPagamento() { return rpDataPagamento; }

    public void setRpDataPagamento(Date rpDataPagamento) { this.rpDataPagamento = rpDataPagamento; }

    public Long getId() {
        return rpId;
    }

    @Override
    public String toString() {
        return rpId.toString();
    }
}
