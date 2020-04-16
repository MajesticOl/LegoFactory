package command;

import main.Usb;
import org.usb4java.DeviceHandle;
import org.usb4java.LibUsb;
import org.usb4java.LibUsbException;
import ui.Console;
import ui.ConsoleState;

public class UiDevice extends Command {
    public UiDevice(Usb usb) {
        super(usb);
    }

    @Override
    public void execute() {
        System.out.println("Device: " + usb.getDevice().toString());
        DeviceHandle handle = new DeviceHandle();
        int result = LibUsb.open(usb.getDevice(), handle);
        if (result != LibUsb.SUCCESS) throw new LibUsbException("Unable to open USB device", result);
        try
        {
            // Use device handle here
        }
        finally
        {
            LibUsb.close(handle);
        }
        Console.state = ConsoleState.EXIT;
    }
}
