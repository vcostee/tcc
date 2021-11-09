package ENUM;

public enum TipoTelefone {
    FIXO("Fixo"),
    MOVEL("Móvel");

    private String descricao;

    TipoTelefone(String s) {
        descricao = s;
    }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }
}
