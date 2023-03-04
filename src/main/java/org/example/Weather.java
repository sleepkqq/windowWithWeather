package org.example;

import org.jsoup.Jsoup;

public class Weather {

    private final String day;

    public Weather(String day) {
        this.day = day;
    }



    public String getWeather() {
        try {

            var document = Jsoup.connect("https://meteoinfo.ru/forecasts/russia/moscow-area/moscow").get();
            var elements = document.select("td.td_short_gr");
            if (day.equals("today")) {
                return elements.get(1).text() + "\n" + elements.get(17).text();
            } else if (day.equals("tomorrow")) {
                return elements.get(2).text() + "\n" + elements.get(18).text();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "nothing";
    }

}
