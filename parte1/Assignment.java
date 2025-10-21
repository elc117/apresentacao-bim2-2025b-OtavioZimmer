import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;

public class Assignment {

  protected LocalDate dueDate;
  protected String description;
  protected boolean pending;
  protected LocalDate submitDate;
  
  public Assignment(LocalDate dueDate, String description) {
    this.dueDate = dueDate;
    this.description = description;
    this.submitDate = null;
    this.pending = true;
  }

  public String getDescription() {
    return this.description;
  }

  public boolean isPending() {
    return this.pending;
  }

  public void complete(LocalDate date) {
    this.submitDate = date;
    this.pending = false;
  }

  public int daysLeft() {
    TemporalUnit unit = ChronoUnit.DAYS;
    return (int) LocalDate.now().until(dueDate, unit);
  }

  private String status() {
    if (!isPending()) {
        return "done";
    }
    else if (daysLeft() < 0) {
        return "late";
    }
    else {
        return "due in " + daysLeft() + " days";
    }
  }

  public String message() {
    return "Assignment " + this.description + " is " + status(); 
  }

  @Override
  public String toString() {
    return String.format("{ dueDate='%s', description='%s', pending='%s', submitDate='%s'}",
            dueDate, description, pending, submitDate);
  }
}