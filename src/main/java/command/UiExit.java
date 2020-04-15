package command;

public class UiExit implements Command{
    @Override
    public void execute() {
        System.out.println("Bye Bye....");
    }
}
