package debug;

/*
      Responder as seguintes perguntas:

      a) que linha está dando problema?

      b) qual é a excessão retornada pela execução da app?

      c) - colocar um breakpoint na primeira linha do metodo main
         - entrar dentro do método calculaMediaDaTurma (STEP INTO)
         - inspecione os valores das variáveis quando o cursor chegar na linha (System.out.printf("Nota do aluno %s: ", alunos[i]);
           -alunos:
           -notas:
           -soma:

      d) debugar a app e analisar o pq está dando esse erro, responder o motivo aqui:

      e) concertar a app
     */
public class Exercicio {

    public static void main(String[] args) {
        String[] alunos = {"Camila", "Lucas", "Bruna", "Pedro"};
        Double[] notas = {};

        double media = calculaMediaDaTurma(alunos, notas);

        System.out.printf("Média da turma %.1f", media);
    }

    public static double calculaMediaDaTurma(String[] alunos, Double[] notas) {

        double soma = 0;
        for (int i = 0; i < alunos.length; i++) {
            System.out.printf("Nota do aluno %s: ", alunos[i]);
            soma += notas[i];
        }

        return soma / alunos.length;
    }

}
