package br.com.dbc.aula4.homework;

public class ContaCorrente {
    Cliente cliente;
    String numeroConta;
    String agencia;
    double saldo;
    double chequeEspecial;

    public boolean sacar(double valor) {
        if (valor == 0) {
            System.err.println("Não é possível realizar saque de zero reais.");
            return false;
        } else if (valor > (saldo + chequeEspecial)) {
            System.err.println("Saldo e cheque especial insuficientes para realizar o saque.");
            return false;
        } else {
            saldo -= valor;
        }
        return true;
    }

    public boolean depositar(double valor) {
        if (valor <= 0) {
            System.err.println("não é possível depositar valor negativo ou zero");
            return false;
        } else {
            saldo += valor;
        }
        return true;
    }

    public double retornarSaldoCompleto() {
        return saldo + chequeEspecial;
    }

    public boolean transferir(ContaCorrente contaCorrente, double valor) {
        boolean conseguiuSacar = sacar(valor);
        boolean conseguiuDepositar = false;
        if (conseguiuSacar) {
            conseguiuDepositar = contaCorrente.depositar(valor);
        }
        return conseguiuDepositar && conseguiuSacar;
    }

    public void imprimirContaCorrente(){
//        String nomeCliente = cliente.nome;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "cliente=" + cliente +
                ", numeroConta='" + numeroConta + '\'' +
                ", agencia=" + agencia +
                ", saldo=" + saldo +
                ", chequeEspecial=" + chequeEspecial +
                '}';
    }
}
