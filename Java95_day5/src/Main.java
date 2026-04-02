//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    LocalDate date = LocalDate.of(2026, 3, 17);

    LocalDate today = LocalDate.now();
    int currentYear = today.getYear();
    LocalDate nextSunday = date.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
    LocalDate next7 = date.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    System.out.println(nextSunday.format(formatter));
    int day=0;
    while ((nextSunday.getYear() == currentYear && nextSunday.isBefore(today)) || (next7.getYear()==currentYear&& nextSunday.isBefore(today))){
        day++;
        nextSunday=nextSunday.plusWeeks(1);
        next7=next7.plusWeeks(1);
    }
    long days = ChronoUnit.DAYS.between(date, today)-day;
    System.out.printf("Deadline:" +days);
}
