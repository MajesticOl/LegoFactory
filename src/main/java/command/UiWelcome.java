package command;

import main.Usb;
import ui.Console;
import ui.ConsoleState;

import java.util.Scanner;

public class UiWelcome extends Command{

    public UiWelcome(Usb usb) {
        super(usb);
    }

    @Override
    public void execute() {
        int a;
        Scanner in = new Scanner(System.in);
        usb.list_device();
        System.out.println("Choose a device or q to exit\n:");

        if(in.hasNextInt()) {
            usb.select_device(in.nextInt()-1);
            Console.state = ConsoleState.DEVICE;
        }else{
            Console.state = ConsoleState.EXIT;
        }
    }
}
