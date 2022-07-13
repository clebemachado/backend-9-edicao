package br.com.dbc.aula4.interfaces;

public class Main {
    public static void main(String[] args) {
//        Veiculo veiculo = new Veiculo();
        Veiculo veiculoMinhaCarroca = new Carroca();
        Carroca minhaCarroca = (Carroca) veiculoMinhaCarroca;
        minhaCarroca.setNome("Carroça Alada");
        minhaCarroca.setQuilometragem(14000);
        minhaCarroca.setQuantidadeDeCavalos(2);

        Carro mustang = new Carro();
        mustang.setQuilometragem(0);
        mustang.setModeloMotor("5,0 l V8");
        mustang.setPotencia(483); //HP
        mustang.setVelocidadeMaxima(250); //km/h
        mustang.setNome("Mustangão dos guri");

        Barco barco = new Barco();
        barco.setNome("Titanic");
        barco.setQuilometragem(1500);
        barco.setVelocidadeMaxima(100);
        barco.setMaterialCasco("Aço");
        barco.setQuantidadeMaximaPassageiros(2785);

        Motor motorMustang = mustang;
        Veiculo veiculoMustang = mustang;
        System.out.println(motorMustang.getPotencia());
        System.out.println(veiculoMustang.getQuilometragem());

//        Motor motor = new Motor();
    }
}
