package gtlp.groundmc.lobby.util

import de.tr7zw.itemnbtapi.NBTItem
import gtlp.groundmc.lobby.enums.NBTIdentifier
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

/**
 * Extension to {@link de.tr7zw.itemnbtapi.NBTItem}
 * Allows the use of {@link NBTIdentifier} as key.
 */
class NBTItemExt(item: ItemStack) : NBTItem(item) {

    fun setInteger(identifier: NBTIdentifier, value: Int) {
        super.setInteger(identifier.toString(), value)
    }

    fun setBoolean(identifier: NBTIdentifier, value: Boolean) {
        super.setBoolean(identifier.toString(), value)
    }

    fun setString(identifier: NBTIdentifier, value: String) {
        super.setString(identifier.toString(), value)
    }

    fun setDouble(identifier: NBTIdentifier, value: Double) {
        super.setDouble(identifier.toString(), value)
    }

    fun hasKey(identifier: NBTIdentifier): Boolean {
        return super.hasKey(identifier.toString())
    }

    fun removeKey(identifier: NBTIdentifier) {
        super.removeKey(identifier.toString())
    }

    fun getInteger(identifier: NBTIdentifier): Int {
        return super.getInteger(identifier.toString())
    }

    fun getBoolean(identifier: NBTIdentifier): Boolean {
        return super.getBoolean(identifier.toString())
    }

    fun getString(identifier: NBTIdentifier): String {
        return super.getString(identifier.toString())
    }

    fun getDouble(identifier: NBTIdentifier): Double {
        return super.getDouble(identifier.toString())
    }

    var displayName: String?
        set(displayName) {
        val meta = item.itemMeta
        meta.displayName = displayName
        item.itemMeta = meta
    }
        get(): String? {
        return item.itemMeta.displayName
    }

    fun addEnchantment(enchantment: Enchantment, level: Int = 1, ignoreLevelRestrictions: Boolean = true) {
        val meta = item.itemMeta
        meta.addEnchant(enchantment, level, ignoreLevelRestrictions)
        item.itemMeta = meta
    }

    fun removeEnchantment(enchantment: Enchantment) {
        val meta = item.itemMeta
        meta.removeEnchant(enchantment)
        item.itemMeta = meta
    }

    fun addItemFlags(vararg flags: ItemFlag) {
        val meta = item.itemMeta
        meta.addItemFlags(*flags)
        item.itemMeta = meta
    }

    fun removeItemFlags(vararg flags: ItemFlag) {
        val meta = item.itemMeta
        meta.removeItemFlags(*flags)
        item.itemMeta = meta
    }

}