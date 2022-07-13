package br.com.dbc.aula7;

public class Main {
    public static void main(String[] args) {
        TipoUsuario tipoUsuario = TipoUsuario.USUARIO_EMPRESA;
//        TipoUsuario tipoUsuarioColaborador = new TipoUsuario();
        System.out.println(tipoUsuario);

        TipoUsuario[] values = TipoUsuario.values();
        for (TipoUsuario tipo : values) {
            System.out.print(tipo + " ");
            System.out.print(tipo.getDescricao() + " ");
            System.out.println(tipo.ordinal() + " ");
        }
        TipoUsuario usuario = TipoUsuario.valueOf("USUARIO_DEV");
        System.out.println(usuario);

        switch(usuario){
            case USUARIO_DEV -> {
                System.out.println("Criar usuário do tipo Dev");
            }
            case USUARIO_EMPRESA -> {
                System.out.println("Criar usuário do tipo empresa");
            }
            case USUARIO_COLABORADOR -> {
                System.out.println("Criar usuário do tipo colaborador");
            }
            default -> {}
        }
    }
}
