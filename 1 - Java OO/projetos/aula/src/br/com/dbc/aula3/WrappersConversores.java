package br.com.dbc.aula3;

public class WrappersConversores {
    public static void main(String[] args) {
//        Integer integer = null;
//        integer = 5;
//
//        int meuInteiro = integer;
//        integer = meuInteiro;
//        System.out.println(meuInteiro);
//        System.out.println(integer);
//
//        Integer meuInteiroWrapper = meuInteiro;
//        meuInteiro = meuInteiroWrapper;
//
//        byte meuByte = 50;
//        int meuInt = meuByte;
//
//        meuByte = (byte) meuInt;
//
//        long meuLong = meuInt;
//        meuInt = (int) meuLong;
//
//        Integer valor = 5;
//        Long meuValorLong = valor.longValue();

        String aluno = "Pedro"; // tipos primitivos, wrappers e String
        passarPorValor(aluno);
        System.out.println(aluno);

        Pessoa pedro = new Pessoa(); //OBJETO
        pedro.nome = "Pedro";
        passarPorReferencia(pedro);
        System.out.println(pedro.nome);
    }

    static void passarPorValor(String valor){
        valor = "Teste";
    }

    static void passarPorReferencia(Pessoa pessoa){
        pessoa.nome = "João";
    }
}
