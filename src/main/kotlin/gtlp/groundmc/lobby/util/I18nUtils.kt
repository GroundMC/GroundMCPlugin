package gtlp.groundmc.lobby.util

/*
 Copyright (c) 2003 Erik Bengtson and others. All rights reserved.
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.

 Contributors:
 ...
 */


import gtlp.groundmc.lobby.LobbyMain
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.util.*

/**
 * Utility class for internationalization. This class provides a
 * central location to do specialized formatting in both
 * a default and a locale specific manner.

 * @version $Revision: 1.2 $
 */
object I18nUtils {

    /**
     * Convert a string based locale into a Locale Object.
     * Assumes the string has form "{language}_{country}_{variant}".
     * Examples: "en", "de_DE", "_GB", "en_US_WIN", "de__POSIX", "fr_MAC"

     * @param localeString The String
     * *
     * @return the Locale
     */
    fun getLocaleFromString(localeString: String): Locale {
        LobbyMain.logger.entering(I18nUtils::class, "getLocaleFromString")
        @Suppress("NAME_SHADOWING")
        var localeString = localeString
        localeString = localeString.trim { it <= ' ' }
        if (localeString.toLowerCase() == "default") {
            return Locale.getDefault()
        }

        // Extract language
        val languageIndex = localeString.indexOf('_')
        val language: String
        if (languageIndex == -1) {
            // No further "_" so is "{language}" only
            return Locale(localeString, "")
        } else {
            language = localeString.substring(0, languageIndex)
        }

        // Extract country
        val countryIndex = localeString.indexOf('_', languageIndex + 1)
        val country: String
        if (countryIndex == -1) {
            // No further "_" so is "{language}_{country}"
            country = localeString.substring(languageIndex + 1)
            return Locale(language, country)
        } else {
            // Assume all remaining is the variant so is "{language}_{country}_{variant}"
            country = localeString.substring(languageIndex + 1, countryIndex)
            val variant = localeString.substring(countryIndex + 1)
            return Locale(language, country, variant)
        }
    }

    fun getLocaleFromCommandSender(sender: CommandSender): Locale {
        LobbyMain.logger.entering(I18nUtils::class, "getLocaleFromCommandSender")
        if (sender is Player) {
            return getLocaleFromString(sender.spigot().locale)
        } else {
            return Locale.getDefault()
        }
    }
}
