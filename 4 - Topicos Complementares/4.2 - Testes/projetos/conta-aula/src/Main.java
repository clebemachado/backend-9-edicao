public class Main {
    public static void main(String[] args) {
        ContaPoupanca poupancaMaicon = criarPoupancaMaicon(); //1500
        poupancaMaicon.creditarTaxa();
        ContaCorrente contaCorrenteJeremias = criarContaCorrenteJeremias(); //1800
        ContaPagamento contaPagamentoJeremias = criarContaPagamentoJeremias(); //500

        poupancaMaicon.sacar(500);
        poupancaMaicon.transferir(contaCorrenteJeremias, 1000);
        contaCorrenteJeremias.transferir(contaPagamentoJeremias, 100);

        poupancaMaicon.imprimir();
        contaCorrenteJeremias.imprimirContaCorrente();
        contaPagamentoJeremias.imprimir();
    }

    public static ContaPoupanca criarPoupancaMaicon() {
        Endereco endereco1 = new Endereco();
        endereco1.setTipo(1);
        endereco1.setLogradouro("Rua desembargador pedro silva");
        endereco1.setNumero(1520);
        endereco1.setCep("88080700");
        endereco1.setComplemento("proximo à escola batatinha");
        endereco1.setCidade("Florianópolis");
        endereco1.setEstado("SC");
        endereco1.setPais("Brasil");

        Endereco endereco2 = new Endereco();
        endereco2.setTipo(2);
        endereco2.setLogradouro("Av. Andaraí, 531");
        endereco2.setNumero(531);
        endereco2.setCep("91350110");
        endereco2.setComplemento("DBC Company");
        endereco2.setCidade("Porto Alegre");
        endereco2.setEstado("RS");
        endereco2.setPais("Brasil");

        Contato contato1 = new Contato();
        contato1.setDescricao("Telefone Pessoal");
        contato1.setTelefone("51998453566");
        contato1.setTipo(1);

        Contato contato2 = new Contato();
        contato2.setDescricao("Telefone Comercial");
        contato2.setTelefone("5133307777");
        contato2.setTipo(2);

        Cliente clienteMaicon = new Cliente();
        clienteMaicon.setCpf("92319463070");
        clienteMaicon.setNome("Maicon Machado Gerardi da Silva");
        clienteMaicon.getEnderecos()[0] = endereco1;
        clienteMaicon.getEnderecos()[1] = endereco2;
        clienteMaicon.getContatos()[0] = contato1;
        clienteMaicon.getContatos()[1] = contato2;

        ContaPoupanca contaPoupancaMaicon = new ContaPoupanca();
        contaPoupancaMaicon.setCliente(clienteMaicon);
        contaPoupancaMaicon.setNumeroConta("1345");
        contaPoupancaMaicon.setAgencia("10");
        contaPoupancaMaicon.setSaldo(0);

        contaPoupancaMaicon.depositar(1500);
        return contaPoupancaMaicon;
    }

    public static Cliente getJeremias() {
        Endereco endereco1 = new Endereco();
        endereco1.setTipo(1);
        endereco1.setLogradouro("Rua Engenheiro Dechamps");
        endereco1.setNumero(207);
        endereco1.setCep("30280490");
        endereco1.setComplemento("");
        endereco1.setCidade("Belo Horizonte");
        endereco1.setEstado("MG");
        endereco1.setPais("Brasil");

        Endereco endereco2 = new Endereco();
        endereco2.setTipo(2);
        endereco2.setLogradouro("Av. Andaraí, 531");
        endereco2.setNumero(531);
        endereco2.setCep("91350110");
        endereco2.setComplemento("DBC Company");
        endereco2.setCidade("Porto Alegre");
        endereco2.setEstado("RS");
        endereco2.setPais("Brasil");

        Contato contato1 = new Contato();
        contato1.setDescricao("Telefone Pessoal");
        contato1.setTelefone("31988453566");
        contato1.setTipo(1);

        Contato contato2 = new Contato();
        contato2.setDescricao("Telefone Comercial");
        contato2.setTelefone("5133307777");
        contato2.setTipo(2);

        Cliente clienteJeremias = new Cliente();
        clienteJeremias.setCpf("84319463070");
        clienteJeremias.setNome("Jeremias Juliano Peixoto");
        clienteJeremias.getEnderecos()[0] = endereco1;
        clienteJeremias.getEnderecos()[1] = endereco2;
        clienteJeremias.getContatos()[0] = contato1;
        clienteJeremias.getContatos()[1] = contato2;
        return clienteJeremias;
    }

    public static ContaCorrente criarContaCorrenteJeremias() {
        Cliente clienteJeremias = getJeremias();

        ContaCorrente contaCorrenteJeremias = new ContaCorrente();
        contaCorrenteJeremias.setCliente(clienteJeremias);
        contaCorrenteJeremias.setNumeroConta("13456");
        contaCorrenteJeremias.setAgencia("11");
        contaCorrenteJeremias.setChequeEspecial(8000.0);
        contaCorrenteJeremias.setSaldo(0);

        contaCorrenteJeremias.depositar(1800);
        return contaCorrenteJeremias;
    }

    public static ContaPagamento criarContaPagamentoJeremias() {
        Cliente clienteJeremias = getJeremias();

        ContaPagamento contaPagamentoJeremias = new ContaPagamento();
        contaPagamentoJeremias.setCliente(clienteJeremias);
        contaPagamentoJeremias.setNumeroConta("13456");
        contaPagamentoJeremias.setAgencia("11");
        contaPagamentoJeremias.setSaldo(0);

        contaPagamentoJeremias.depositar(500);
        return contaPagamentoJeremias;
    }
}
