package me.rerere.dailysign.config

import me.rerere.dailysign.DailySignPlugin
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

abstract class ConfigFile(
    val name: String
){
    val file = File(DailySignPlugin.dataFolder, name).apply {
        if(!exists()){
            DailySignPlugin.saveResource(name, false)
        }
    }

    val yaml = YamlConfiguration.loadConfiguration(file)

    fun save() {
        yaml.save(file)
    }
}