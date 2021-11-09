package ENUM;

public enum OrigemMovimento {
    CONTA_PAGA("Física"),
    CONTA_RECEBIDA("Jurídica"),
    ENTRADA("Entrada Financeira"),
    SAIDA("Saída Financeira"),
    OUTRO("Outros");

    private String descricao;

    OrigemMovimento(String s) {
        descricao = s;
    }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }
}
