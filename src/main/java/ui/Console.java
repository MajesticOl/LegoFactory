package ui;

import command.*;
import main.Usb;

import java.util.ArrayList;
import java.util.List;

public class Console {
    public static ConsoleState state = ConsoleState.WELCOME;
    private final List<Command> console_commands = new ArrayList<>();
    private Usb usb;

    public Console(Usb usb_devices){
        System.out.println("init");
        this.usb = usb_devices;
    }

    public void run(){
        while(true){
            switch(this.state){
                case WELCOME:
                    console_commands.add(new UiWelcome(this.usb));
                    break;
                case DEVICE:
                    console_commands.add(new UiDevice(this.usb));
                    break;
                case EXIT:
                    console_commands.add(new UiExit(this.usb));
                    break;
            }

            for(Command command : console_commands){
                command.execute();
            }
            console_commands.clear();

            if(Console.state == ConsoleState.EXIT) break;
        }
    }
}
