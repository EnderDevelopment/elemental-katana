package com.enderdevelopment.plugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("KatanaPlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("KatanaPlugin has been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("givekatana")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Only players can use this command.");
                return true;
            }

            Player player = (Player) sender;

            if (args.length != 1) {
                player.sendMessage("Usage: /givekatana <type>");
                return true;
            }

            String type = args[0].toLowerCase();
            ItemStack katana = createKatana(type);

            if (katana == null) {
                player.sendMessage("Invalid katana type. Available types: iron, diamond, shadow, fire, water, cloud, earth, wind");
                return true;
            }

            player.getInventory().addItem(katana);
            player.sendMessage("You have been given a " + type + " katana!");
            return true;
        }
        return false;
    }

    private ItemStack createKatana(String type) {
        Material material;
        String name;
        String lore;

        switch (type) {
            case "iron":
                material = Material.IRON_SWORD;
                name = ChatColor.GRAY + "Iron Katana";
                lore = "A basic iron katana.";
                break;
            case "diamond":
                material = Material.DIAMOND_SWORD;
                name = ChatColor.AQUA + "Diamond Katana";
                lore = "A powerful diamond katana.";
                break;
            case "shadow":
                material = Material.IRON_SWORD;
                name = ChatColor.DARK_PURPLE + "Shadow Katana";
                lore = "A katana with necromancy powers.";
                break;
            case "fire":
                material = Material.IRON_SWORD;
                name = ChatColor.RED + "Fire Katana";
                lore = "A katana that deals fire damage.";
                break;
            case "water":
                material = Material.IRON_SWORD;
                name = ChatColor.BLUE + "Water Katana";
                lore = "A katana that deals water damage.";
                break;
            case "cloud":
                material = Material.IRON_SWORD;
                name = ChatColor.WHITE + "Cloud Katana";
                lore = "A katana that deals cloud damage.";
                break;
            case "earth":
                material = Material.IRON_SWORD;
                name = ChatColor.GREEN + "Earth Katana";
                lore = "A katana that deals earth damage.";
                break;
            case "wind":
                material = Material.IRON_SWORD;
                name = ChatColor.YELLOW + "Wind Katana";
                lore = "A katana that deals wind damage.";
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