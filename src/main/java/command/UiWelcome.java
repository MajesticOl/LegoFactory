package command;

import ui.Console;
import ui.ConsoleState;

import java.util.Scanner;

public class UiWelcome implements Command{

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.println("1.Exit\n:");
        int a = in.nextInt();
        if(a == 1) Console.state = ConsoleState.EXIT;
    }
}
