public class ContaPagamento extends Conta implements Impressao {
    private static final Double TAXA_SAQUE = 4.25;

    @Override
    public boolean sacar(double valor) {
        return super.sacar(valor + TAXA_SAQUE);
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }
}
