import java.time.LocalDate;

public class GroupAssignment extends Assignment {
  private String teamMates;

  @Override
  public String message() {
    if (!isPending()){
        return super.message();
    }
    return "Group " + super.message() + " - call " + this.teamMates;
  }

  public GroupAssignment(LocalDate dueDate, String description, String teamMates) {
    super(dueDate, description);
    this.teamMates = teamMates;
  }
}