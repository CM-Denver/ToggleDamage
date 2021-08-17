package com.william.plugin;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class ToggleListener implements Listener {

	private Main main;
	
	public ToggleListener(Main main) {
		this.main = main;
	}
	
	//Creates an array of players that have invincibility enabled:
	ArrayList<Player> enabled = new ArrayList<>();
	
	//Enables invincibility when a player clicks a nether star (adds them to 'enabled' array):
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		
		Player player = e.getPlayer();
		
		if (player.getItemInHand().getType().equals(Material.NETHER_STAR)) {
			//Checks if player is in 'enabled' array (has invincibility enabled):
			if (enabled.contains(player)) {
				enabled.remove(player);
				player.sendMessage("You have disabled it!");
			} 
			else {
				player.sendMessage("You have enabled it!");
				enabled.add(player);
			}
		}
		
	}
	
	//If player has invincibility enabled, damage taken is set to zero:
	@EventHandler
	public void onPlayerTakeDamage(EntityDamageEvent e) {
		//Check if damaged entity is a player:
		if (e.getEntity() instanceof Player) {
			Player player = (Player) e.getEntity();
			//Checks if player is in 'enabled' array (has invincibility enabled):
			if (enabled.contains(player)) {
				e.setDamage(0);
			}
		}
	}
	
}
