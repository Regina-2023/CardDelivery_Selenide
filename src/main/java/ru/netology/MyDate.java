package ru.netology;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class MyDate {

    public String text_date() throws ParseException {
        DateFormat outputFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.US);
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

        String inputText = LocalDate.now().plusDays(3).toString();
        Date date = inputFormat.parse(inputText);
        String outputText = outputFormat.format(date);
        return outputText;
    }

}
