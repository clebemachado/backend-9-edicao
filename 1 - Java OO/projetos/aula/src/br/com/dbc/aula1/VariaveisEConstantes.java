package br.com.dbc.aula1;

public class VariaveisEConstantes {
    public static void main(String[] args) {
        // inicia o meu programa atribuindo as variáveis
        /*
            Variavel idade,
            nome,
            altura e assim por diante...
        */
        int idade = 30;
        String nome = "Maicon";
        float altura = 1.73f;
        double peso = 75.0;
        boolean ehSolteiro = false;

        final String SEU_NOME_EH = "seu nome é ";

        nome = "Pedro";
        // SEU_NOME_EH = "seu apelido é ";

        // imprime o valor das variáveis
        System.out.println(SEU_NOME_EH + nome + ", tem " + idade + " anos, "+ altura + "m e " + peso + "kg.");
    }
}
