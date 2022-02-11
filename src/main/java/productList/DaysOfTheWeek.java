package productList;

public enum DaysOfTheWeek {
    MONDAY("Monday", 1),
    TUESDAY("Tuesday", 2),
    WEDNESDAY("Wednesday",3),
    THURSDAY("Thuersday", 4),
    FRIDAY("Friday",5),
    SATURDAY("Saturday",6),
    SUNDAY("Sunday", 7);

    String name;
    int dayNumber;

    DaysOfTheWeek(String name, int dayNumber) {
        this.name = name;
        this.dayNumber = dayNumber;
    }
}
