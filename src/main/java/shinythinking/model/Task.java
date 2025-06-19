package shinythinking.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Task {
    protected String title;
    protected String url;
    protected String selector;
    private boolean done;
    private LocalDate validateDate;
    private String userID;
    private DateStreak previous;
    private DateStreak today;

    public void init(String title, String url, String targetElement, boolean done, LocalDate validateDate, String userID) {
        this.title = title;
        this.url = url;
        this.selector = targetElement;
        this.done = done;
        this.validateDate = validateDate;
        this.userID = userID;
    }

    protected void setDone(boolean done) {
        this.done = done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isDone() {
        return done;
    }

    protected void setUserID(String userID) {
        this.userID = userID;
    }

    protected void setValidateDate(LocalDate validateDate) {
        this.validateDate = validateDate;
    }

    protected boolean getDone() {
        return done;
    }

    protected String getUserID() {
        return userID;
    }

    protected LocalDate getValidateDate() {
        return validateDate;
    }
}
