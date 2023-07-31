package myclasses;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyDate {
    public String textDate(Integer days) {
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate inputText = LocalDate.now().plusDays(days);
        return outputFormat.format(inputText);
    }

}
