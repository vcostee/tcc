package ENUM;

public enum TipoAjuste {
    ENTRADA("Entrada"),
    SAIDA("Saída");

    private String descricao;

    TipoAjuste(String s) {
        descricao = s;
    }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }
}
