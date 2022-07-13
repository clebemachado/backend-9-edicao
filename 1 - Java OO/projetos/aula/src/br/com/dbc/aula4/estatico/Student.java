package br.com.dbc.aula4.estatico;

public class Student {
    static String college = "ITS";//static variable
    int rollno;//instance variable
    String name;

    //constructor
    Student(int r, String n) {
        rollno = r;
        name = n;
    }

    //method to display the values
    void display() {
        System.out.println(rollno + " " + name + " " + college);
    }
}
