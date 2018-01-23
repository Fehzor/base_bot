package Bot.Fields;

import Bot.Fields.Field;
import Bot.Launcher;
import static Bot.SuperRandom.oRan;
import com.vdurmont.emoji.Emoji;
import java.awt.Color;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import sx.blah.discord.handle.obj.IRole;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.handle.obj.Permissions;
import sx.blah.discord.util.RoleBuilder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FF6EB4
 */
public class UserData {
    public static Field<ArrayList<String>> IDList = new Field<>("USERDATA","IDLIST",new ArrayList<>());
    private static HashMap<String,UserData> UserList = new HashMap<>();
    
    public static UserData getUD(IUser user){
        if(!UserList.containsKey(user.getStringID())){
            if(!IDList.getData().contains(user.getStringID())){
                IDList.getData().add(user.getStringID());
            }
            UserList.put(user.getStringID(),new UserData(user));
        }
        
        IDList.writeData(IDList.getData());
        
        //if(UserList.get(user.getID()).name.equals("Clint Eastwood's Character")){
        //    UserList.get(user.getID()).name = user.getName();
        //}
        
        return UserList.get(user.getStringID());
    }
    
    public static UserData getUD(long ID){
        return getUD(Launcher.client.getUserByID(ID));
    }
    
    
    public String name = "Nameless Hero Of Legend";
    public String ID = "00002";
    
    public Field<Integer> lols;
    public Field<HashMap<String,Integer>> emoji;
    public Field<Integer> blocks;
    
    public Field<Long> role;
    
    
    public UserData(IUser user){
        instantiateFields(user);
    }
    
    public String toString(){
        String s = "**"+name+"**\n\n";
        
        s+="Lols: "+lols.getData()+"\n";
        s+="Chat Blocks: "+blocks.getData()+"\n";
        s+="Emoji: "+emoji.getData()+"\n";
        
        
        
        return s;
    }
    
    private void instantiateFields(IUser user){
        
        this.name = user.getName();
        this.ID = user.getStringID();
        
        lols = new Field<>(this.ID,"lols",0);
        emoji = new Field<>(this.ID,"emoji",new HashMap<>());
        blocks = new Field<>(this.ID,"blocks",0);
        
        role = new Field<>(this.ID,"role",this.getRoleIfApplicable(ID).getLongID());
        
        IRole theRole = Launcher.client.getRoleByID(role.getData());
        user.addRole(theRole);
    }
    
    private IRole getRoleIfApplicable(String ID){
        List<IRole> roles = Launcher.client.getRoles();
        
        for(IRole R : roles){
            if(R.getName().equals(""+ID)){
                return R;
            }
        }
        
        //Otherwise, create a role for the new friend!
        
        //GETS THE FIRST GUILD POSSIBLE FOR THIS
        RoleBuilder RB = new RoleBuilder(Launcher.client.getGuilds().get(0));
        
        RB.withName(ID);
        RB.withColor(new Color(oRan.nextInt(255),oRan.nextInt(255),oRan.nextInt(255)));
        
        IRole role = RB.build();
        return role;
    }
}
