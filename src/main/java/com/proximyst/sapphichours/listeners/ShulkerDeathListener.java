package com.proximyst.sapphichours.listeners;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class ShulkerDeathListener implements Listener {
  @EventHandler
  public void onShulkerDeath(EntityDeathEvent event) {
    if (event.getEntityType() != EntityType.SHULKER) {
      return;
    }

    // Replace drops with 2 shells.
    event.getDrops().clear();
    event.getDrops().add(new ItemStack(Material.SHULKER_SHELL, 2));
  }
}
