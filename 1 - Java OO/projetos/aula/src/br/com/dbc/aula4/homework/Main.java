package br.com.dbc.aula4.homework;

public class Main {
    public static void main(String[] args) {
        ContaCorrente contaCorrenteMaicon = criarContaCorrenteMaicon();
        ContaCorrente contaCorrenteJeremias = criarContaCorrenteJeremias();

        contaCorrenteMaicon.imprimirContaCorrente();
        contaCorrenteJeremias.imprimirContaCorrente();

        contaCorrenteMaicon.sacar(1000);
        System.out.println(contaCorrenteMaicon.retornarSaldoCompleto());

        contaCorrenteJeremias.transferir(contaCorrenteMaicon, 2800);

        contaCorrenteMaicon.imprimirContaCorrente();
        contaCorrenteJeremias.imprimirContaCorrente();
    }

    public static ContaCorrente criarContaCorrenteMaicon(){
        Endereco endereco1 = new Endereco();
        endereco1.tipo = 1;
        endereco1.logradouro = "Rua desembargador pedro silva";
        endereco1.numero = 1520;
        endereco1.cep = "88080700";
        endereco1.complemento = "proximo à escola batatinha";
        endereco1.cidade = "Florianópolis";
        endereco1.estado = "SC";
        endereco1.pais = "Brasil";

        Endereco endereco2 = new Endereco();
        endereco2.tipo = 2;
        endereco2.logradouro = "Av. Andaraí, 531";
        endereco2.numero = 531;
        endereco2.cep = "91350110";
        endereco2.complemento = "DBC Company";
        endereco2.cidade = "Porto Alegre";
        endereco2.estado = "RS";
        endereco2.pais = "Brasil";

        Contato contato1 = new Contato();
        contato1.descricao = "Telefone Pessoal";
        contato1.telefone = "51998453566";
        contato1.tipo = 1;

        Contato contato2 = new Contato();
        contato2.descricao = "Telefone Comercial";
        contato2.telefone = "5133307777";
        contato2.tipo = 2;

        Cliente clienteMaicon = new Cliente();
        clienteMaicon.cpf = "92319463070";
        clienteMaicon.nome = "Maicon Machado Gerardi da Silva";
        clienteMaicon.enderecos[0] = endereco1;
        clienteMaicon.enderecos[1] = endereco2;
        clienteMaicon.contatos[0] = contato1;
        clienteMaicon.contatos[1] = contato2;

        ContaCorrente contaCorrenteMaicon = new ContaCorrente();
        contaCorrenteMaicon.cliente = clienteMaicon;
        contaCorrenteMaicon.numeroConta = "1345";
        contaCorrenteMaicon.agencia = "10";
        contaCorrenteMaicon.chequeEspecial = 1500.0;
        contaCorrenteMaicon.saldo = 0;

        contaCorrenteMaicon.depositar(150);
        return contaCorrenteMaicon;
    }

    public static ContaCorrente criarContaCorrenteJeremias(){
        Endereco endereco1 = new Endereco();
        endereco1.tipo = 1;
        endereco1.logradouro = "Rua Engenheiro Dechamps";
        endereco1.numero = 207;
        endereco1.cep = "30280490";
        endereco1.complemento = "";
        endereco1.cidade = "Belo Horizonte";
        endereco1.estado = "MG";
        endereco1.pais = "Brasil";

        Endereco endereco2 = new Endereco();
        endereco2.tipo = 2;
        endereco2.logradouro = "Av. Andaraí, 531";
        endereco2.numero = 531;
        endereco2.cep = "91350110";
        endereco2.complemento = "DBC Company";
        endereco2.cidade = "Porto Alegre";
        endereco2.estado = "RS";
        endereco2.pais = "Brasil";

        Contato contato1 = new Contato();
        contato1.descricao = "Telefone Pessoal";
        contato1.telefone = "31988453566";
        contato1.tipo = 1;

        Contato contato2 = new Contato();
        contato2.descricao = "Telefone Comercial";
        contato2.telefone = "5133307777";
        contato2.tipo = 2;

        Cliente clienteJeremias = new Cliente();
        clienteJeremias.cpf = "92319463070";
        clienteJeremias.nome = "Jeremias Juliano Peixoto";
        clienteJeremias.enderecos[0] = endereco1;
        clienteJeremias.enderecos[1] = endereco2;
        clienteJeremias.contatos[0] = contato1;
        clienteJeremias.contatos[1] = contato2;

        ContaCorrente contaCorrenteJeremias = new ContaCorrente();
        contaCorrenteJeremias.cliente = clienteJeremias;
        contaCorrenteJeremias.numeroConta = "1345";
        contaCorrenteJeremias.agencia = "10";
        contaCorrenteJeremias.chequeEspecial = 8000.0;
        contaCorrenteJeremias.saldo = 0;

        contaCorrenteJeremias.depositar(1800);
        return contaCorrenteJeremias;
    }
}
