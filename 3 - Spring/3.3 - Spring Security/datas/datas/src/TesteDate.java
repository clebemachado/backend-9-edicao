import java.util.Date;

public class TesteDate {
    public static void main(String[] args) {
        Date minhaData = new Date();
        System.out.println(minhaData);

        Date minhaDataZero = new Date(0); // 1000 * 60 * 60 * 24...
        System.out.println(minhaDataZero);

        Date d1 = new Date(2000, 11, 21);
        System.out.println(d1);
        Date d2 = new Date();  // Current date
        Date d3 = new Date(2010, 1, 3);

        boolean a = d3.after(d1);
        System.out.println("Date d3 comes after " +
                "date d2: " + a);

        boolean b = d3.before(d2);
        System.out.println("Date d3 comes before " +
                "date d2: " + b);

        int c = d1.compareTo(d2);
        System.out.println(c);
    }
}
