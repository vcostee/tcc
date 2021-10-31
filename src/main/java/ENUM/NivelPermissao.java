package ENUM;

public enum NivelPermissao {
    ADM("Administrador"),
    UUSUARIO("Usuário");

    private String descricao;

    NivelPermissao(String s) {
        descricao = s;
    }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }
}
