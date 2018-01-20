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
public class Kick extends Command{
    
    public Kick(){
        this.category = -1;
        this.signature = new String[]{"!kick"};
        this.description = "Kicks user #whatever if you're a mod";
    }
    
    public void execute(String params, long ID){
        List<IRole> roles = Launcher.client.getUserByID(ID).getRolesForGuild(Launcher.client.getGuilds().get(0));
        String [] get = params.split(" ",2);
        Long L = Long.parseLong(get[0]);
        
        for(IRole R : roles){
            if(R.getLongID() == 394870024814329856L){
                IGuild G = Launcher.client.getGuilds().get(0);
                G.kickUser(G.getUserByID(L));
                //System.out.println("KICKED "+L);
                Field<String> reason = new Field<>("kick",get[0],"");

                reason.append("Kick-\n"+get[1]+" - "+Launcher.client.getUserByID(ID).getName()+", ID="+ID+"\n");
                Launcher.send("Kick-\n"+get[1]+" - "+Launcher.client.getUserByID(ID).getName()+", ID="+ID+"\n",Launcher.client.getChannelByID(394869593816039425L));
            }
        }
    }
}