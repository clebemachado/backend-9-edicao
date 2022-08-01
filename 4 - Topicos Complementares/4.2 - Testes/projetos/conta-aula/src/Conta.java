public abstract class Conta implements Movimentacao {
    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private double saldo;

    @Override
    public boolean transferir(Conta conta, double valor) {
        boolean conseguiuSacar = sacar(valor);
        boolean conseguiuDepositar = false;
        if (conseguiuSacar) {
            conseguiuDepositar = conta.depositar(valor);
        }
        return conseguiuDepositar && conseguiuSacar;
    }

    @Override
    public boolean depositar(double valor) {
        if (valor <= 0) {
            System.err.println("não é possível depositar valor negativo ou zero");
            return false;
        } else {
            saldo += valor;
        }
        return true;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.err.println("Não é possível realizar saque de zero reais.");
            return false;
        } else if (valor > saldo) {
            System.err.println("Saldo e cheque especial insuficientes para realizar o saque.");
            return false;
        } else {
            setSaldo(getSaldo() - valor);
        }
        return true;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "cliente=" + cliente +
                ", numeroConta='" + numeroConta + '\'' +
                ", agencia=" + agencia +
                ", saldo=" + saldo +
                '}';
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
