package ENUM;

public enum TipoMovimento {
    ENTRADA("Entrada"),
    SAIDA("Saida");

    private String descricao;

    TipoMovimento(String s) {
        descricao = s;
    }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }
}
