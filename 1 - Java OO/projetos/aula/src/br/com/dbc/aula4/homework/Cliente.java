package br.com.dbc.aula4.homework;

public class Cliente {
    String nome;
    String cpf;
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];

    public void imprimirCliente() {
        System.out.println(this);
        imprimirContatos();
        imprimirEnderecos();
    }

    public void imprimirContatos() {
        for (int i = 0; i < contatos.length; i++) {
            System.out.println(contatos[i]);
        }
    }

    public void imprimirEnderecos() {
        for (int i = 0; i < enderecos.length; i++) {
            System.out.println(enderecos[i]);
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
