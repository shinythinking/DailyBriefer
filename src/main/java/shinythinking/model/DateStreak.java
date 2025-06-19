package shinythinking.model;

import java.time.LocalDate;

class DateStreak {
    private LocalDate localDate;
    private int streak;

    DateStreak(LocalDate localDate, int streak) {
        this.localDate = localDate;
        this.streak = streak;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public int getStreak() {
        return streak;
    }
}
