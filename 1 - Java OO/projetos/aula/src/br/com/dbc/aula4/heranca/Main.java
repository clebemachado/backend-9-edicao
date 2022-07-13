package br.com.dbc.aula4.heranca;

public class Main {
    public static void main(String[] args) {
//        Veiculo meuCarroNovo = new Carro();
//        Veiculo barco2 = new Barco();
//        Veiculo carroVoador2 = new CarroVoador();
//        meuCarroNovo.setVelocidadeMaxima(455);
//
//        CarroVoador carroVoadorX = (CarroVoador) new Carro();
//
//        Carro carro = new CarroVoador();
//
//        CarroVoador meuCarroCast = (CarroVoador) carro;
        Carro mustang = new Carro();
        mustang.setQuilometragem(0);
        mustang.setModeloMotor("5,0 l V8");
        mustang.setPotencia(483); //HP
        mustang.setVelocidadeMaxima(250); //km/h
        mustang.setNome("Mustangão dos guri");

//        Veiculo veiculo = new Veiculo();

        Barco barco = new Barco();
        barco.setNome("Titanic");
        barco.setQuilometragem(1500);
        barco.setVelocidadeMaxima(100);
        barco.setMaterialCasco("Aço");
        barco.setQuantidadeMaximaPassageiros(2785);

        CarroVoador carroVoador = new CarroVoador();
        carroVoador.setNome("Delorian");
        carroVoador.setAltitude(1000l);
    }
}
