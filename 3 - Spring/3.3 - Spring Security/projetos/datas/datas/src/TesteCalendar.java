import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TesteCalendar {
    public static void main(String[] args) {
//        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar);
//        Date time = calendar.getTime();
//        System.out.println(time);
//
//        System.out.println("Data/Hora atual: " + calendar.getTime());
//        System.out.println("Ano: " + calendar.get(Calendar.YEAR));
//        System.out.println("Mês: " + (calendar.get(Calendar.MONTH) + 1));
//        System.out.println("Dia do Mês: " + calendar.get(Calendar.DAY_OF_MONTH));
//
//        Calendar c = Calendar.getInstance();
//        c.set(Calendar.YEAR, 1995);
//        c.set(Calendar.MONTH, Calendar.APRIL);
//        c.set(Calendar.DAY_OF_MONTH, 20);
//|
        //https://mkyong.com/java/java-display-list-of-timezone-with-gmt/
        //https://docs.oracle.com/javase/7/docs/api/java/util/TimeZone.html
//        Calendar calendarTimeZone = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
//        calendarTimeZone.setTimeZone(TimeZone.getTimeZone("Etc/GMT+12"));
//
//        System.out.println(calendarTimeZone.getTimeZone());
//        System.out.println(calendarTimeZone.getTime());

        Calendar c = Calendar.getInstance();
        Date data = c.getTime();

        Locale brasil = new Locale("pt", "BR"); //Retorna do país e a língua
        Locale eua = Locale.US;
        Locale italia = Locale.ITALIAN;

        //Formata a data
        DateFormat formataData = DateFormat.getDateInstance(DateFormat.FULL, italia);
        System.out.println("Data atual com formatação: " + formataData.format(data));

        //Formata Hora
        DateFormat hora = DateFormat.getTimeInstance();
        System.out.println("Hora formatada: " + hora.format(data));

        //Formata Data e Hora
        DateFormat dtHora = DateFormat.getDateTimeInstance();
        System.out.println(dtHora.format(data));
        //https://docs.oracle.com/javase/10/docs/api/java/text/SimpleDateFormat.html
        DateFormat meuFormato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
        System.out.println(meuFormato.format(data));
        DateFormat meuFormato2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
        System.out.println(meuFormato2.format(new Date()));

//        Date date = new Date();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        System.out.println(calendar);
    }
}
