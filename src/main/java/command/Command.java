package command;

import main.Usb;

public abstract class Command {
    Usb usb;
    public Command(Usb usb_devices){
        this.usb = usb_devices;
    }
    public abstract void execute();
}
