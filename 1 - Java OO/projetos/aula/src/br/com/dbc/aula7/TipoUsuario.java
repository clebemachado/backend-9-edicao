package br.com.dbc.aula7;

public enum TipoUsuario {
    USUARIO_DEV("Usuário Desenvolvedor"), // 0
    USUARIO_EMPRESA("Usuário Empresa"), //1
    USUARIO_COLABORADOR("Usuário Colaborador"); //2

    private String descricao;

    TipoUsuario(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
