package ui;

import command.Command;
import command.UiExit;
import command.UiWelcome;

import java.util.ArrayList;
import java.util.List;

public class Console {

    public static ConsoleState state = ConsoleState.WELCOME;
    private final List<Command> console_commands = new ArrayList<>();

    public Console(){
        System.out.println("init");
    }

    public void run(){
        while(true){
            switch(this.state){
                case WELCOME: console_commands.add(new UiWelcome());
                case EXIT: console_commands.add(new UiExit());
            }

            for(Command command : console_commands){
                command.execute();
            }
            console_commands.clear();

            if(Console.state == ConsoleState.EXIT) break;
        }
    }
}
