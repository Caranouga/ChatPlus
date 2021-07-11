package fr.caranouga.chatplus;

import org.bukkit.plugin.java.JavaPlugin;

import fr.caranouga.chatplus.commands.CommandHelp;
import fr.caranouga.chatplus.listeners.Listeners;

public class ChatPlus extends JavaPlugin {

	public void onEnable() {
		saveDefaultConfig();
		
		this.getCommand("cphelp").setExecutor(new CommandHelp(this));
		getServer().getPluginManager().registerEvents(new Listeners(this), this);
	}
}
