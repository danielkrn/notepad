package lv.ctco.notepad;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reminder extends Alarm implements Expirable {
    private LocalDate date;

    @Override
    public boolean contains(String str) {
        return super.contains(str)
                || getFormattedDate().contains(str);
    }

    @Override
    public void askData() {
        date = Main.askDate("Remainder date (" + Main.DATE_PATTERN + ")");
        super.askData();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean isExpired() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dt = LocalDateTime.of(getDate(), getTime());
        return now.isAfter(dt);
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + getId() +
                ", date='" + getFormattedDate() + '\'' +
                ", time='" + getFormattedTime() + '\'' +
                ", text='" + getText() + '\'' +
                '}';
    }

    private String getFormattedDate() {
        return date.format(Main.DATE_FORMATTER);
    }
}
