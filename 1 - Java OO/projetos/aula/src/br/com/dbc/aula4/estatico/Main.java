package br.com.dbc.aula4.estatico;

public class Main {
    public static void main(String[] args) {
        System.out.println(Student.college);

        Student s1 = new Student(111,"Karan");
        Student s2 = new Student(222,"Aryan");
        //we can change the college of all objects by the single line of code
        Student.college="BBDIT";
        s1.display();
        s2.display();

        Student s3 = new Student(333,"Dayvidson");
        s3.display();

        Math.tan(123.4);
        int soma = Utils.soma(10, 20);
        System.out.println(soma);
    }
}
