public class ContaPoupanca extends Conta implements Impressao {
    private static final double TAXA_MENSAL = 1.01;

    public void creditarTaxa() {
        this.setSaldo(getSaldo() * TAXA_MENSAL);
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "cliente=" + getCliente() +
                ", numeroConta='" + getNumeroConta() + '\'' +
                ", agencia=" + getAgencia() +
                ", saldo=" + getSaldo() +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }
}
