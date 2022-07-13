package br.com.dbc.aula7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExercicioException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = 0;
        int n2 = 0;

        boolean dadosValidados = false;
        while (!dadosValidados) {
            try {
                System.out.println("Digite n1 ");
                n1 = Integer.parseInt(scanner.nextLine()); // 1

                System.out.println("Digite n2 ");
                n2 = Integer.parseInt(scanner.nextLine()); // 0

                System.out.println(divisao(n1, n2));

                dadosValidados = true;
            } catch (InputMismatchException | NumberFormatException ex) {
                ex.printStackTrace();
                System.out.println("digite novamente as informações");
            } catch (ArithmeticException ex) {
                ex.printStackTrace();
            } finally {
                System.out.println("executou finally");
                if (dadosValidados) {
                    scanner.close();
                }
            }
        }
    }

    public static int divisao(int n1, int n2) throws ArithmeticException {
        return n1 / n2;
    }
}
