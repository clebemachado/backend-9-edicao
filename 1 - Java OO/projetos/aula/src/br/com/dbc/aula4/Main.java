package br.com.dbc.aula4;

public class Main {
    public static void main(String[] args) {

        Carro carroNulo = new Carro();
        System.out.println(carroNulo);

        Carro tesla = new Carro();
        tesla.setModelo("Tesla Model X");
        tesla.setQuilometragem(15000);
        System.out.println(tesla);

        Carro bmw = new Carro("BMW", 8000);
        System.out.println(bmw);

        Carro fiesta = new Carro("Tesla");
        System.out.println(fiesta);




//        System.out.println(fiesta.getModelo());
//
////        fiesta.modelo = "Fiesta";
//        fiesta.setModelo("Fiesta");
////        fiesta.quilometragem = 75000;
//        fiesta.setQuilometragem(45000);
//
//        System.out.println(fiesta.getModelo());
////        System.out.println(fiesta.quilometragem);
//        System.out.println(fiesta.getQuilometragem());
    }
}
