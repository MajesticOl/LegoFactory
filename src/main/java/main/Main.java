package main;

import org.usb4java.LibUsb;
import ui.Console;

public class Main {

    public static void main(String[] args) {
        try {
            Usb usb_devices = new Usb();
            Usb.list_device();
            Console console = new Console();
            console.run();
        }finally{
            LibUsb.exit(null);
        }
    }
}
