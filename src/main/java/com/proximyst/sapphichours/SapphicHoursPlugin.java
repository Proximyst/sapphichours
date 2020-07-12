package com.proximyst.sapphichours;

import co.aikar.commands.PaperCommandManager;
import com.proximyst.sapphichours.commands.HomeCommand;
import com.proximyst.sapphichours.listeners.CreeperGriefListener;
import com.proximyst.sapphichours.listeners.GhastGriefListener;
import com.proximyst.sapphichours.listeners.ShulkerDeathListener;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class SapphicHoursPlugin extends JavaPlugin {
  private PaperCommandManager commandManager;

  @SuppressWarnings("deprecation") // Developer warning.
  @Override
  public void onEnable() {
    commandManager = new PaperCommandManager(this);
    commandManager.enableUnstableAPI("help");

    commandManager.registerCommand(new HomeCommand());

    getServer().getPluginManager().registerEvents(new GhastGriefListener(), this);
    getServer().getPluginManager().registerEvents(new CreeperGriefListener(), this);
    getServer().getPluginManager().registerEvents(new ShulkerDeathListener(), this);
  }

  @Override
  public void onDisable() {
    commandManager.unregisterCommands();
    HandlerList.unregisterAll(this);
  }
}
