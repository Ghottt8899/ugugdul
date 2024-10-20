import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DaysCalculator {

    public static void main(String[] args) {
        String startDateStr = "1978-09-01";
        String endDateStr = "2022-09-01";
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        LocalDate startDate = LocalDate.parse(startDateStr, formatter);
        LocalDate endDate = LocalDate.parse(endDateStr, formatter);
        
        long totalDays = ChronoUnit.DAYS.between(startDate, endDate) + 1;

        long weekdays = 0;
        long weekends = 0;

        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
                weekends++;
            } else {
                weekdays++;
            }
            currentDate = currentDate.plusDays(1);
        }

        System.out.println("Total days: " + totalDays);
        System.out.println("Weekdays: " + weekdays);
        System.out.println("Weekends: " + weekends);
    }
}
