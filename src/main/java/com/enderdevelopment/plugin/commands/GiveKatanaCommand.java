package com.enderdevelopment.plugin.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class GiveKatanaCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length != 1) {
            player.sendMessage("Usage: /givekatana <type>");
            return true;
        }

        String katanaType = args[0].toLowerCase();
        ItemStack katana = createKatana(katanaType);

        if (katana == null) {
            player.sendMessage("Invalid katana type. Available types: iron, diamond, shadow, fire, water, cloud, earth, wind");
            return true;
        }

        player.getInventory().addItem(katana);
        player.sendMessage("You received a " + katanaType + " katana!");
        return true;
    }

    private ItemStack createKatana(String type) {
        Material material;
        String name;
        String[] lore;

        switch (type) {
            case "iron":
                material = Material.IRON_SWORD;
                name = "Iron Katana";
                lore = new String[]{"A basic iron katana"};
                break;
            case "diamond":
                material = Material.DIAMOND_SWORD;
                name = "Diamond Katana";
                lore = new String[]{"A powerful diamond katana"};
                break;
            case "shadow":
                material = Material.NETHERITE_SWORD;
                name = "Shadow Katana";
                lore = new String[]{"A katana of shadows", "Necromancy power"};
                break;
            case "fire":
                material = Material.NETHERITE_SWORD;
                name = "Fire Katana";
                lore = new String[]{"A katana of flames", "Fire damage"};
                break;
            case "water":
                material = Material.NETHERITE_SWORD;
                name = "Water Katana";
                lore = new String[]{"A katana of water", "Water manipulation"};
                break;
            case "cloud":
                material = Material.NETHERITE_SWORD;
                name = "Cloud Katana";
                lore = new String[]{"A katana of clouds", "Cloud manipulation"};
                break;
            case "earth":
                material = Material.NETHERITE_SWORD;
                name = "Earth Katana";
                lore = new String[]{"A katana of earth", "Earth manipulation"};
                break;
            case "wind":
                material = Material.NETHERITE_SWORD;
                name = "Wind Katana";
                lore = new String[]{"A katana of wind", "Wind manipulation"};
                break;
            default:
                return null;
        }

        ItemStack katana = new ItemStack(material);
        ItemMeta meta = katana.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        katana.setItemMeta(meta);

        return katana;
    }
}