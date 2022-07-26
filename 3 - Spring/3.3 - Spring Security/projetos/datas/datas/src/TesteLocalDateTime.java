import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TesteLocalDateTime {

    public static void main(String[] args) {
//        localDate();
        localDateTime();
//        localTime();
    }

    private static void localDate() {
        LocalDate now = LocalDate.now();
        System.out.println(now);

        LocalDate of = LocalDate.of(2015, 2, 20);
        System.out.println(of);
        LocalDate parse = LocalDate.parse("2015-02-20");
        System.out.println(parse);

        LocalDate minhaData = LocalDate.now();
        minhaData = minhaData.plusDays(10);
        System.out.println();
        System.out.println(minhaData.getDayOfWeek());

        int twelve = LocalDate.parse("2016-06-12").getDayOfMonth();
        System.out.println(twelve);
        boolean leapYear = LocalDate.parse("2024-06-12").isLeapYear(); // bissexto
        System.out.println(leapYear);

        LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.YEARS);
        LocalDate previousMonthSameDayPlus = LocalDate.now().plus(1, ChronoUnit.MONTHS);

        boolean notBefore = LocalDate.parse("2016-06-12")
                .isBefore(LocalDate.parse("2016-06-11"));
        System.out.println(notBefore);

        boolean isAfter = LocalDate.parse("2016-06-12")
                .isAfter(LocalDate.parse("2016-06-11"));
        System.out.println(isAfter);
    }

    private static void localDateTime() {
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(now);
//
//        LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30);
//        LocalDateTime.parse("2015-02-20T06:30:00");
//
//        LocalDateTime localDateTime = LocalDateTime.now();
//        localDateTime = localDateTime.plusDays(1);
//        localDateTime = localDateTime.minusHours(2);
//
//        localDateTime.getMonth();

        ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);

        ZoneId zoneId = ZoneId.of("Europe/Paris");

        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneId);
        System.out.println(zonedDateTime);

        LocalDate initialDate = LocalDate.parse("2007-05-10");
        LocalDate finalDate = initialDate.plus(Period.ofDays(5));
        int five = Period.between(initialDate, finalDate).getDays();
        System.out.println(five);
        long five2 = ChronoUnit.DAYS.between(initialDate, finalDate);


        LocalTime initialTime = LocalTime.of(6, 30, 0);

        LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));
        long thirty = Duration.between(initialTime, finalTime).getSeconds();
        long thirty2 = ChronoUnit.SECONDS.between(initialTime, finalTime);

        LocalDateTime localDateTime = LocalDateTime.of(2015, Month.JANUARY, 25, 6, 30);
        String localDateString = localDateTime.format(DateTimeFormatter.ISO_DATE);
        String dataFormatada = localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println(dataFormatada);
        System.out.println(localDateString);

        // LocalDate -> LocalDateTime
        LocalDate data = LocalDate.of(2018, Month.SEPTEMBER, 17);
        LocalDateTime dt = data.atTime(10, 30);

        // LocalDateTime -> LocalDate
        LocalDateTime localDateTime2 = LocalDateTime.now();
        LocalDate localDate = localDateTime2.toLocalDate();
        System.out.println(localDate);
    }

    private static void localTime() {
        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalTime sixThirty = LocalTime.parse("06:30");
        LocalTime sixThirty2 = LocalTime.of(6, 30);

        sixThirty2 = sixThirty2.plus(1, ChronoUnit.HOURS);

        int hour = sixThirty.getHour();
        System.out.println(hour);

        boolean isBefore = LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30"));
        boolean isAfter = LocalTime.parse("06:30").isAfter(LocalTime.parse("07:30"));
    }
}
