package com.william.plugin;
import org.bukkit.Bukkit;
import org.bukkit.boss.BossBar;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{

	//Create variable outside onEnable(). We can access this variable if we have access to the Main class:
	BossBar bossbar;
	
	@Override
	public void onEnable() {
		System.out.println("ToggleDamage plugin has worked (sorta)");
		
		//Add ToggleListener:
		Bukkit.getPluginManager().registerEvents(new ToggleListener(this), this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("ToggleDamage plugin disabled");
	}
	
}
