/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bot.Commands.Implementation;

import Bot.Commands.Command;
import Bot.Commands.CommandParser;
import Bot.Fields.Field;
import Bot.Launcher;
import static Bot.SuperRandom.oRan;
import java.util.ArrayList;
import java.util.List;
import sx.blah.discord.handle.impl.obj.Guild;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IRole;

/**
 *
 * @author FF6EB4
 */
public class Why extends Command{
    
    public Why(){
        this.category = -1;
        this.signature = new String[]{"!why"};
        this.description = "Returns why a user was banned.";
    }
    
    public void execute(String params, long ID){
        List<IRole> roles = Launcher.client.getUserByID(ID).getRolesForGuild(Launcher.client.getGuilds().get(0));
        Long L = Long.parseLong(params);
        
        
        Field<String> reasonkicks = new Field<>("kick",params,"");
        Launcher.PM("**"+params+" has been kicked...**\n\n"+reasonkicks.getData(),ID);
        
        Field<String> reason = new Field<>("ban",params,"...they aren't banned??");
        Launcher.PM("**"+params+" was banned because...**\n\n"+reason.getData(),ID);
    }
}