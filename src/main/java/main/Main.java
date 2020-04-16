package main;

import org.usb4java.LibUsb;
import ui.Console;

public class Main {

    public static void main(String[] args) {
        try {
            Usb usb_devices = new Usb();
            Console console = new Console(usb_devices);
            console.run();
        }finally{
            LibUsb.exit(null);
        }
    }
}
