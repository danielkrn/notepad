package lv.ctco.notepad;

import java.time.LocalTime;

public class Alarm extends StickyNote implements Expirable {
    private LocalTime time;

    @Override
    public boolean contains(String str) {
        return super.contains(str)
                || getFormattedTime().contains(str);
    }

    protected String getFormattedTime() {
        return time.format(Main.TIME_FORMATTER);
    }

    @Override
    public void askData() {
        this.time = Main.askTime("Enter time");
        super.askData();
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + getId() +
                ", date='" + getFormattedTime() + '\'' +
                ", text='" + getText() + '\'' +
                '}';
    }

    @Override
    public boolean isExpired() {
        var now = LocalTime.now();
        return now.isAfter(time);
    }
}
