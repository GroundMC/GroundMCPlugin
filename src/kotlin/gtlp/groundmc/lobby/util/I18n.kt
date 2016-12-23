package gtlp.groundmc.lobby.util

import org.bukkit.ChatColor
import java.util.*
import java.util.concurrent.ConcurrentHashMap

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
     * Automatically parses color codes using the [colorChar]
     *
     * @param key A string representing the common name for a localized string, used in resources
     * @param locale The locale to translate to. If not given, [Locale.US]
     *
     * @return The localized and parsed string or null, if the key has no translation
     */
    fun getString(key: String, locale: Locale = Locale.US): String? {

        val s = bundleCache.get(key, locale) ?: return null
        return ChatColor.translateAlternateColorCodes(colorChar, s)
    }

    /**
     * Returns a list of localized strings (if available) for the given keys.
     * Automatically parses color codes using the [colorChar]
     *
     * @param keys A collection of strings representing the common names for the localized strings, used in resources
     * @param locale The locale to translate to. If not given, [Locale.US]
     *
     * @return The localized and parsed strings with null where strings could not be localized
     *
     * @see getString
     */
    fun getStrings(keys: Collection<String>, locale: Locale = Locale.US): Array<String?> {
        return keys.map { it -> getString(it, locale) }.toTypedArray()
    }

    /**
     * Returns a list of localized strings (if available) for the given keys.
     * Automatically parses color codes using the [colorChar]
     *
     * @param keys A collection of strings representing the common names for the localized strings, used in resources
     * @param locale The locale to translate to.
     *
     * @return The localized and parsed strings with null where strings could not be localized
     *
     * @see getString
     */
    fun getStrings(keys: Collection<String>, locale: String): Array<String?> {
        return keys.map { it -> getString(it, locale) }.toTypedArray()
    }

    /**
     * Returns the localized string (if available) for a given key.
     * The locale is parsed using [I18nUtils.getLocaleFromString]
     * Automatically parses color codes using the [colorChar]
     *
     * @param key A string representing the common name for a localized string, used in resources
     * @param locale The locale to translate to as a string.
     *
     * @return The localized and parsed string or null, if the key has no translation
     */
    fun getString(key: String, locale: String): String? {
        val s: String = bundleCache.get(key, I18nUtils.getLocaleFromString(locale)) ?: return null
        return ChatColor.translateAlternateColorCodes(colorChar, s)
    }

    /**
     * A cache for dynamically loading and storing used resource bundles.
     * Does not implement removing items from the cache because of low memory impact
     */
    class ResourceBundleCache(val name: String) {
        /**
         * A map holding resource bundles for locales
         */
        internal val backingMap = ConcurrentHashMap<Locale, ResourceBundle>()

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
                backingMap[locale] = ResourceBundle.getBundle(name, locale)
            }
            return backingMap.getOrPut(locale, { ResourceBundle.getBundle(name, locale) }).getString(key)
        }
    }
}