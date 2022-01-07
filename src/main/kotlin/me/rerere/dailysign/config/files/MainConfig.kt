package me.rerere.dailysign.config.files

import me.rerere.dailysign.config.ConfigFile

class MainConfig : ConfigFile("config.yml"){
    val language = yaml.getString("language","en_US")!!
}