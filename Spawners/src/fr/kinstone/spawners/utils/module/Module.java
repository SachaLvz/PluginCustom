package fr.kinstone.spawners.utils.module;

import fr.kinstone.spawners.SpawnersPlugin;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public abstract class Module {

	public void registerListener(Listener listener) {
		Bukkit.getPluginManager().registerEvents(listener, SpawnersPlugin.getInstance());
	}
	
	public void registerCommand(Object obj) {
		SpawnersPlugin.getInstance().getCommandFramework().registerCommands(obj);
	}
	
	
	public void enable() {}
	public void disable() {}
	

}
