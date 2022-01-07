package me.rerere.dailysign.util

import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Translate color code for string
 *
 * @return translated String
 */
fun String.translateColor(colorCode: Char = '&'): String =
    net.md_5.bungee.api.ChatColor.translateAlternateColorCodes(colorCode, translateHex())

/**
 * Translate color code for string list
 *
 * @return translated String list
 */
fun List<String>.translateColor(colorCode: Char = '&'): List<String> = this.map { it.translateColor(colorCode) }

// hex color pattern: `&#FFFFFF`
private val HEX_PATTERN = Pattern.compile("&(#[A-Fa-f0-9]{6})")

// translate hex color
private fun String.translateHex(): String {
    var text = this
    var matcher: Matcher = HEX_PATTERN.matcher(text)
    while (matcher.find()) {
        val color = text.substring(matcher.start(), matcher.end())
        text = text.replace(color, net.md_5.bungee.api.ChatColor.of(color.substring(1)).toString())
        matcher = HEX_PATTERN.matcher(text) // 更新matcher
    }
    return text
}