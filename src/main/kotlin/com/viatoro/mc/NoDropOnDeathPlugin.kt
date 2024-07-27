package com.viatoro.mc

import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.block.Chest
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.inventory.ItemStack

class NoDropOnDeathPlugin : JavaPlugin(), Listener {

    override fun onEnable() {
        logger.info { "onEnable is called!" }
        server.pluginManager.registerEvents(this, this)
    }

    @EventHandler
    fun onPlayerDeath(event: PlayerDeathEvent) {
//        val player = event.entity
//        if (player.hasPermission("keepinventory.keep")) {
//            event.keepInventory = true
//            event.keepLevel = true
//            event.droppedExp = 0
//            event.drops.clear()
//        }

        event.keepInventory = true
        event.keepLevel = true
        event.droppedExp = 0
        event.drops.clear()
    }

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        if (!event.player.hasPlayedBefore()) {
            val spawnLocation = event.player.location
            val block: Block = spawnLocation.block.getRelative(0, 1, 0)
            block.type = Material.CHEST
            if (block.state is Chest) {
                val chest = block.state as Chest
                chest.inventory.addItem(ItemStack(Material.STONE_AXE))
                chest.inventory.addItem(ItemStack(Material.STONE_PICKAXE))
                chest.inventory.addItem(ItemStack(Material.STONE_SWORD))
                chest.inventory.addItem(ItemStack(Material.STICK,64))
                chest.inventory.addItem(ItemStack(Material.OAK_PLANKS,64))
                chest.inventory.addItem(ItemStack(Material.OAK_LOG,64))
                chest.inventory.addItem(ItemStack(Material.OAK_SAPLING,64))
                chest.inventory.addItem(ItemStack(Material.PUMPKIN_SEEDS,64))
                chest.inventory.addItem(ItemStack(Material.BEETROOT_SEEDS,64))
                chest.inventory.addItem(ItemStack(Material.MELON_SEEDS,64))
                chest.inventory.addItem(ItemStack(Material.TORCHFLOWER_SEEDS,64))
                chest.inventory.addItem(ItemStack(Material.WHEAT_SEEDS,64))
                chest.inventory.addItem(ItemStack(Material.IRON_BARS,64))
                chest.inventory.addItem(ItemStack(Material.POTATO,64))
                chest.inventory.addItem(ItemStack(Material.CARROT,64))
                chest.inventory.addItem(ItemStack(Material.APPLE,64))
                chest.inventory.addItem(ItemStack(Material.BREAD, 64))
                chest.inventory.addItem(ItemStack(Material.TORCH, 64))
            }
        }
    }
}