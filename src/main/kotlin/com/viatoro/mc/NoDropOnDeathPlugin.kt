package com.viatoro.mc

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.plugin.java.JavaPlugin

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
}