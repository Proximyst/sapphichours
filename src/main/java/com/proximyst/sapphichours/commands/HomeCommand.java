package com.proximyst.sapphichours.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Location;
import org.bukkit.entity.Player;

@CommandAlias("home|ehome|gohome")
public class HomeCommand extends BaseCommand {
  @Default
  @Description("Go to your bed.")
  public void root(Player sender) {
    Location bed = sender.getBedSpawnLocation();
    if (bed == null) {
      sender.sendMessage(
          new ComponentBuilder("You have not slept in a bed, or it is currently missing.")
              .color(ChatColor.RED)
              .create()
      );
      return;
    }

    bed.setDirection(sender.getLocation().getDirection());
    sender.teleportAsync(bed);
  }
}
