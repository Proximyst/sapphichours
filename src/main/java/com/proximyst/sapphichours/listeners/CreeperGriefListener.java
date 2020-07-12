package com.proximyst.sapphichours.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class CreeperGriefListener implements Listener {
  @EventHandler
  public void onExplode(EntityExplodeEvent event) {
    if (event.getEntityType() != EntityType.CREEPER) {
      return;
    }

    event.blockList().clear();
  }
}
