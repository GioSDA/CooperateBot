package io.github.GioSDA.listeners;

import io.github.GioSDA.Main;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReceivedListener extends ListenerAdapter {

	//Channel Name
	static String channelName = "cooperate";
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
		if (e.getAuthor().isBot() == false) { //Checks for bot
			if (e.getChannel().getName().equals(channelName)) { //Check if correct channel
				try {
					if (Integer.parseInt(e.getMessage().getContentStripped()) == Main.count + 1) { //If correct number
						Main.count++; //Increment 
					} else { //If incorrect Number
						Member m = e.getGuild().retrieveMember(e.getMessage().getAuthor()).complete();
						e.getChannel().sendMessage("The count has been reset to 0. Good job, " + m.getAsMention()).queue(); //Blame
						
						//Apply Roles
						if (Main.count > 999) e.getGuild().addRoleToMember(m, e.getGuild().getRoleById("772302118249824257")).queue();
						if (Main.count > 499) e.getGuild().addRoleToMember(m, e.getGuild().getRoleById("772302073772900353")).queue();
						if (Main.count > 99) e.getGuild().addRoleToMember(m, e.getGuild().getRoleById("772302003031506964")).queue();
						if (Main.count > 49) e.getGuild().addRoleToMember(m, e.getGuild().getRoleById("772302001357717504")).queue();
						if (Main.count > 9) e.getGuild().addRoleToMember(m, e.getGuild().getRoleById("772301940041842688")).queue();
						if (Main.count > 0) e.getGuild().addRoleToMember(m, e.getGuild().getRoleById("772301904818208818")).queue();
						
						//Reset counts
						Main.count = 0;	
					}
				} catch (NumberFormatException ex) { //If not number
					e.getMessage().delete().queue(); //Delete message
				}
			}
		}
		e.getJDA().getPresence().setActivity(Activity.playing("Counting to " + Main.count)); //Change Status
	}
	
}
