package br.com.dbc.aula5;

import java.util.Stack;

public class Pilhas {
    public static void main(String[] args) {
        Stack<String> minhaPilha = new Stack<>();
        minhaPilha.add("Maicon");
        minhaPilha.add("Felipe");
        minhaPilha.add("Roberto");

        System.out.println(minhaPilha);
        String retirado = minhaPilha.pop();
        System.out.println(retirado);
        System.out.println(minhaPilha);
    }
}
