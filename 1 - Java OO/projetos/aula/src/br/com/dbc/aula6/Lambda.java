package br.com.dbc.aula6;

import java.util.function.Function;

public class Lambda {
    public static void main(String[] args) {
        Funcao colocarSr = new Funcao() {
            @Override
            public String gerar(String valor) {
                return "Sr. " + valor;
            }
        };
        System.out.println(colocarSr.gerar("Maicon"));

        Funcao colocarSrLambda = valor -> "Sr. " + valor;
        System.out.println(colocarSrLambda.gerar("Maicon"));

        Function<Double, Double> log = (value) -> Math.log(value);
        Function<Double, Double> sqrt = (value) -> Math.sqrt(value);
        Function<Double, Double> logThenSqrt = sqrt.compose(log);
        //Function<Double, Double> sqrtThenLog = log.andThen(sqrt);
        System.out.println(logThenSqrt.apply(3.14));
// Output: 1.06
        Function<Double, Double> sqrtThenLog = sqrt.andThen(log);
        System.out.println(String.valueOf(sqrtThenLog.apply(3.14)));
// Output: 0.57

    }
}
