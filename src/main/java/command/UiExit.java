package command;

import main.Usb;

public class UiExit extends Command{

    public UiExit(Usb usb) {
        super(usb);
    }

    @Override
    public void execute() {
        System.out.println("Bye Bye....");
    }
}
