/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bot.Commands.Implementation;

import Bot.Commands.Command;
import Bot.Commands.CommandParser;
import Bot.Launcher;

/**
 *
 * @author FF6EB4
 */
public class Commands extends Command{
    
    public Commands(){
        this.category = 0;
        this.signature = new String[] {"!commands"};
        this.description = "Display the list of commands!";
    }
    
    public void execute(String params, long ID){
        String message = "**Commands are as follows:**\n\n";
        
        String a = "**→View Commands**\n";
        String b = "**→Commands**\n";
        String c = "**→Commands**\n";
        String d = "**→Other Commands**\n";
        for(String s : CommandParser.commandList.keySet()){
            Command C = CommandParser.commandList.get(s);
            if(C.category == 1){
                a+=C.toString()+"\n";
            } else if(C.category == 2){
                b+=C.toString()+"\n";
            } else if(C.category == 3) {
                c+=C.toString()+"\n";
            } else if(C.category == -1){
                //Drop it. It's hidden.
            } else {
                d+=C.toString()+"\n";
            }
        }
        
        message+=a+"\n";
        ////message+=b+"\n";
        ////message+=c+"\n";
        message+=d+"\n";
        
        Launcher.PM(message,ID);
    }
}