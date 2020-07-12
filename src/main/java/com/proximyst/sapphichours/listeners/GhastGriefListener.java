package com.proximyst.sapphichours.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Ghast;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class GhastGriefListener implements Listener {
  @EventHandler
  public void onFireballHit(EntityExplodeEvent event) {
    if (event.getEntityType() != EntityType.FIREBALL) {
      return;
    }

    Fireball fireball = (Fireball) event.getEntity();
    if (fireball.getShooter() == null || fireball.getShooter() instanceof Ghast) {
      event.blockList().clear();
    }
  }
}
