import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MeuTesteAulaTest {

    @Test
    public void deveTestarSeOSexoEhMasculino(){
        // setup (criar nossas variaveis)
        String sexo = "masculino";

        // act (método a ser executado) (ação de teste)
        boolean ehMasculino = sexo.equalsIgnoreCase("masculino");

        // assert (ver se a ação retornou o valor esperado)
        Assertions.assertTrue(ehMasculino);
    }

    @Test
    public void deveTestarSeOSexoNaoEhMasculino(){
        // setup (criar nossas variaveis)
        String sexo = "feminino";

        // act (método a ser executado) (ação de teste)
        boolean ehMasculino = sexo.equalsIgnoreCase("masculino");

        // assert (ver se a ação retornou o valor esperado)
        Assertions.assertFalse(ehMasculino);
    }

    @Test
    public void deveTestarSoma(){
        // setup (criar nossas variaveis)
        int v1 = 10;
        int v2 = 20;

        // act (método a ser executado) (ação de teste)
        int resultado = v1 + v2;

        // assert (ver se a ação retornou o valor esperado)
        Assertions.assertEquals(30, resultado);
        Assertions.assertEquals(20, v2);
        Assertions.assertEquals(10, v1);
    }
}
