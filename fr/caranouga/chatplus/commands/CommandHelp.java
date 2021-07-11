package fr.caranouga.chatplus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.caranouga.chatplus.ChatPlus;

public class CommandHelp implements CommandExecutor {
	
	private ChatPlus main;

	public CommandHelp(ChatPlus staffChat) {
		this.main = staffChat;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			player.sendMessage(main.getConfig().getString("layout.help"));
		}else{
			
		}
		return false;
	}

}
