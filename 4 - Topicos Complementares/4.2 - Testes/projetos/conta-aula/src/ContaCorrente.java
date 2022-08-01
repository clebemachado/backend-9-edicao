public class ContaCorrente extends Conta implements Impressao {
    private double chequeEspecial;

    @Override
    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.err.println("Não é possível realizar saque de zero reais.");
            return false;
        } else if (valor > (super.getSaldo() + chequeEspecial)) {
            System.err.println("Saldo e cheque especial insuficientes para realizar o saque.");
            return false;
        } else {
            setSaldo(getSaldo() - valor);
        }
        return true;
    }

    public double retornarSaldoComChequeEspecial() {
        return getSaldo() + chequeEspecial;
    }

    public void imprimirContaCorrente() {
        System.out.println(this);
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "cliente=" + getCliente() +
                ", numeroConta='" + getNumeroConta() + '\'' +
                ", agencia=" + getAgencia() +
                ", saldo=" + getSaldo() +
                ", chequeEspecial=" + chequeEspecial +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }
}
