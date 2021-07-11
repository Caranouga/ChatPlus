package fr.caranouga.chatplus.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import fr.caranouga.chatplus.ChatPlus;

@SuppressWarnings("deprecation")
public class Listeners implements Listener {
	
	private ChatPlus main;

    public Listeners(ChatPlus staffChat) {
		this.main = staffChat;
	}

	@EventHandler
	public void onPlayerChat(PlayerChatEvent e) {
		
		if(e.getMessage().startsWith(main.getConfig().getString("commands.staffchat"))) {
			e.setCancelled(true);
			
			for(Player p : main.getServer().getOnlinePlayers()) {
				if(p.hasPermission("chatplus.receive")) {
					p.sendMessage(main.getConfig().getString("layout.stc").replace("$prefix", main.getConfig().getString("utils.prefix")).replace("$player", e.getPlayer().getName()).replace("$message", e.getMessage().substring(main.getConfig().getString("commands.staffchat").length()+1)).replace("&", "§"));
				}
			}
		}else {
			if(e.getMessage().startsWith(main.getConfig().getString("commands.alert"))) {
				if(e.getPlayer().hasPermission("chatplus.alert")) {
					e.setCancelled(true);
					
					for(Player p : main.getServer().getOnlinePlayers()) {
						System.out.println(main.getConfig().getString("commands.alert").length()+1);
							p.sendMessage(main.getConfig().getString("layout.alert").replace("$prefix", main.getConfig().getString("utils.prefix")).replace("$player", e.getPlayer().getName()).replace("$message", e.getMessage().substring(main.getConfig().getString("commands.alert").length()+1)).replace("&", "§"));
					}
				}
			}else {
				if(e.getMessage().startsWith(main.getConfig().getString("commands.broadcast"))) {
					if(e.getPlayer().hasPermission("chatplus.broadcast")) {
						e.setCancelled(true);
						
						for(Player p : main.getServer().getOnlinePlayers()) {
								p.sendMessage(main.getConfig().getString("layout.broadcast").replace("$prefix", main.getConfig().getString("utils.prefix")).replace("$player", e.getPlayer().getName()).replace("$message", e.getMessage().substring(main.getConfig().getString("commands.broadcast").length()+1)).replace("&", "§"));
						}
					}
				}
			}
		}
	}
	
}
