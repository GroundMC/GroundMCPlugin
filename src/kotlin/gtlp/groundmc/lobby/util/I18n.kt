package gtlp.groundmc.lobby.util

import org.bukkit.ChatColor
import java.util.*

/**
 * Kotlin object to aid with internationalization (I18n)
 */
object I18n {
    /**
     * The ResourceBundleCache used in our project
     */
    val bundleCache = ResourceBundleCache("lang.lobby")

    /**
     * The character used to mark styling codes
     * Hardcoded to the most common value
     */
    val colorChar = '&'

    /**
     * Returns the localized string (if available) for a given key.
     * Automatically parses color codes using the {@link I18n#colorChar}
     *
     * @param key A string representing the common name for a localized string, used in resources
     * @param locale The locale to translate to. If not given, English (US)
     *
     * @return The localized and parsed string or null, if the key has no translation
     */
    fun getString(key: String, locale: Locale = Locale.US): String {
        return ChatColor.translateAlternateColorCodes(colorChar, bundleCache.get(key, locale))
    }

    /**
     * Returns the localized string (if available) for a given key.
     * The locale is parsed using {@link I18nUtils#getLocaleFromString}
     * Automatically parses color codes using the {@link I18n#colorChar}
     *
     * @param key A string representing the common name for a localized string, used in resources
     * @param locale The locale to translate to as a string. If not given, English (US)
     *
     * @return The localized and parsed string or null, if the key has no translation
     */
    fun getString(key: String, locale: String): String {
        return ChatColor.translateAlternateColorCodes(colorChar, bundleCache.get(key, I18nUtils.getLocaleFromString(locale)))
    }

    /**
     * A cache for dynamically loading and storing used resource bundles.
     * Does not implement removing items from the cache because of low memory impact
     */
    class ResourceBundleCache(name: String) {
        /**
         * A map holding resource bundles for locales
         */
        val backingMap = mutableMapOf<Locale, ResourceBundle>()

        /**
         * The name of the bundle to load
         */
        var bundleName: String = name

        /**
         * Returns the localized string (if available) for a given key
         * Adds locales and their resource bundles to the cache, if necessary
         *
         * @param key A string representing the common name for a localized string, used in resources
         * @param locale The locale to translate to. If not given, English (US)
         *
         * @return The localized string or null, if the key has no translation
         */
        fun get(key: String, locale: Locale): String? {
            if (!backingMap.containsKey(locale)) {
                backingMap[locale] = ResourceBundle.getBundle(bundleName, locale)
            }
            return backingMap[locale]?.getString(key)
        }
    }
}