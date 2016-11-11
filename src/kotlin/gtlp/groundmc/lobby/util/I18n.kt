package gtlp.groundmc.lobby.util

import org.bukkit.ChatColor
import java.util.*

/**
 * Created by Marv1 on 17.10.2016.
 */
object I18n {
    val bundleCache = ResourceBundleCache("lang.lobby")
    val colorChar = '&'

    fun getString(key: String, locale: Locale = Locale.US): String? {
        return ChatColor.translateAlternateColorCodes(colorChar, bundleCache.get(key, locale))
    }

    class ResourceBundleCache(name: String) {
        val backingMap = mutableMapOf<Locale, ResourceBundle>()
        var bundleName: String = name

        fun get(key: String, locale: Locale): String? {
            if (!backingMap.containsKey(locale)) {
                backingMap[locale] = ResourceBundle.getBundle(bundleName, locale)
            }
            return backingMap[locale]?.getString(key)
        }
    }

    fun getString(key: String, locale: String): String {
        return ChatColor.translateAlternateColorCodes(colorChar, bundleCache.get(key, I18nUtils.getLocaleFromString(locale)))
    }
}