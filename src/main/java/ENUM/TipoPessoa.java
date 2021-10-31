package ENUM;

public enum TipoPessoa {
    FISICA("Física"),
    JURIDICA("Jurídica");

    private String descricao;

    TipoPessoa(String s) {
        descricao = s;
    }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }
}
