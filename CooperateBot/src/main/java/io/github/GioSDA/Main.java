package io.github.GioSDA;

import javax.security.auth.login.LoginException;

import io.github.GioSDA.listeners.GuildMessageReceivedListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
	public static JDA jda;
	
	//Current count. Starts at 0
	public static int count = 0;
	
	//Token
	public static String token;
	
	public static void main(String[] args) throws LoginException {
		JDABuilder builder = JDABuilder.createDefault("");
		
		//Add event listener
		builder.addEventListeners(new GuildMessageReceivedListener());
		
		//Sets status as counting
		builder.setActivity(Activity.playing("Counting to " + count));
		
		//Set token
		token = args[0];
		builder.setToken(token);
		
		JDA jda = builder.build();
	}
}
