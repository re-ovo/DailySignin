package me.rerere.dailysign

import me.rerere.dailysign.config.ConfigManager
import me.rerere.dailysign.config.LocaleManager
import me.rerere.dailysign.datasource.DataSourceManager
import org.bukkit.plugin.java.JavaPlugin

// Plugin Banner
private val Banner = """
      ____        _ _ _       ____  _             _       
     |  _ \  __ _(_) | |_   _/ ___|(_) __ _ _ __ (_)_ __  
     | | | |/ _` | | | | | | \___ \| |/ _` | '_ \| | '_ \ 
     | |_| | (_| | | | | |_| |___) | | (_| | | | | | | | |
     |____/ \__,_|_|_|_|\__, |____/|_|\__, |_| |_|_|_| |_|
                        |___/         |___/               
""".trimIndent()

class DailySign : JavaPlugin() {
    init {
        instance = this
    }

    lateinit var configManager: ConfigManager
    lateinit var localeManager: LocaleManager
    lateinit var dataSourceManager: DataSourceManager

    override fun onEnable() {
        printBanner()

        configManager = ConfigManager()
        localeManager = LocaleManager().apply {
            load()
        }
        dataSourceManager = DataSourceManager()

        logger.info("Plugin Loaded!")
    }

    override fun onDisable() {

    }

    private fun printBanner() {
        Banner.split("\n")
            .forEach {
                logger.info(it)
            }
    }

    companion object {
        lateinit var instance: DailySign
    }
}

val DailySignPlugin = DailySign.instance