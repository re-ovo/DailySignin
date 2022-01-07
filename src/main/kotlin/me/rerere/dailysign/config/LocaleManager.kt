package me.rerere.dailysign.config

import me.rerere.dailysign.DailySignPlugin
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

class LocaleManager {
    private val localeFolder = File(DailySignPlugin.dataFolder, "locale")
    private lateinit var yaml: YamlConfiguration

    fun load(){
        val selectLanguage = DailySignPlugin.configManager.mainConfig.language
        val file = File(localeFolder, "$selectLanguage.yml").apply {
            if(!exists()){
                DailySignPlugin.saveResource("locale/$selectLanguage.yml", false)
                DailySignPlugin.logger.info("Generated language: $selectLanguage")
            }
        }
        yaml = YamlConfiguration.loadConfiguration(file)
        this.checkMissingValues(selectLanguage, file)
    }

    // Ensure all language values are in the config
    private fun checkMissingValues(selectLanguage: String, file: File){
        val internalLangConfig = YamlConfiguration.loadConfiguration(DailySignPlugin.getResource("locale/$selectLanguage.yml")!!.bufferedReader())
        var counter = 0
        internalLangConfig.getKeys(true).forEach {
            if(!yaml.contains(it)){
                yaml.set(it, internalLangConfig[it])
                counter ++
            }
        }
        yaml.save(file)
        if(counter > 0){
            DailySignPlugin.logger.info("Fixed $counter language options for $selectLanguage.yml")
        }
    }
}