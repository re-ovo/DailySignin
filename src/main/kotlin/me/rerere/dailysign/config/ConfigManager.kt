package me.rerere.dailysign.config

import me.rerere.dailysign.DailySignPlugin
import me.rerere.dailysign.config.files.MainConfig

class ConfigManager {
    init {
        // make sure plugin folder created
        if(!DailySignPlugin.dataFolder.exists()){
            DailySignPlugin.dataFolder.mkdirs()
        }
    }

    val mainConfig = MainConfig()
}