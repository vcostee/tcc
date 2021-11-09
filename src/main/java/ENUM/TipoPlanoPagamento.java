package ENUM;

public enum TipoPlanoPagamento {
    A_VISTA("A vista"),
    PRAZO("A prazo");

    private String descricao;

    TipoPlanoPagamento(String s) {
        descricao = s;
    }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }
}
