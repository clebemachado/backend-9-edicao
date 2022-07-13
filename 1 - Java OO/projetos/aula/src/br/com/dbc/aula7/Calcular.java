package br.com.dbc.aula7;

import java.util.Scanner;

public class Calcular {
    public static void main(String[] args) {
//        calularDivisao(1, 1);

        try {
            System.out.println(calcular(1, -5));
        } catch (NumberFormatException ex){
            ex.printStackTrace();
        } catch (DivisaoNegativaException ex){
            System.out.println(ex.getMessage());
        }

    }

    public static int calcular(int numero1, int numero2) throws DivisaoNegativaException {
        Scanner scanner = new Scanner(System.in);
        try {
//            Integer.parseInt(scanner.nextLine());
            return calularDivisao(numero1, numero2);
        } catch (ArithmeticException ex) {
            ex.printStackTrace();
            System.out.println("não é possível dividir por zero");
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            System.out.println("valor digitado não corresponde ao tipo");
        } finally {
            System.out.println("finally calculo");
        }
        return 0;
    }

    public static int calularDivisao(int n1, int n2) throws NumberFormatException, DivisaoNegativaException {
        if(n2 == 0){
            throw new NumberFormatException("Não é possível dividir por zero.");
        }
        if(n2 < 0){
            throw new DivisaoNegativaException("Não é possível dividir por números negativos");
        }
        return n1 / n2;
    }
}
