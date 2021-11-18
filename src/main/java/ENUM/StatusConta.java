package ENUM;

public enum StatusConta {
    ABERTA("Aberta"),
    PAGA("Paga"),
    RECEBIDA("Recebida"),
    CANCELADA("Cancelada");

    private String descricao;

    StatusConta(String s) {
        descricao = s;
    }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }
}
