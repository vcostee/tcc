package ENUM;

public enum TipoConta {
    PAGAR("Conta Pagar"),
    RECEBER("Conta Receber");

    private String descricao;

    TipoConta(String s) {
        descricao = s;
    }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }
}
