package gtlp.groundmc.lobby.util

import com.google.common.base.Objects
import de.tr7zw.itemnbtapi.NBTItem
import gtlp.groundmc.lobby.enums.NBTIdentifier
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import kotlin.reflect.KClass

/**
 * Extension of [de.tr7zw.itemnbtapi.NBTItem]
 * Allows the use of [NBTIdentifier] as a key.
 */
class NBTItemExt(item: ItemStack) : NBTItem(item) {

    fun setInteger(identifier: NBTIdentifier, value: Int): NBTItemExt {
        super.setInteger(identifier.toString(), value)
        return this
    }

    fun setBoolean(identifier: NBTIdentifier, value: Boolean): NBTItemExt {
        super.setBoolean(identifier.toString(), value)
        return this
    }

    fun setString(identifier: NBTIdentifier, value: String): NBTItemExt {
        super.setString(identifier.toString(), value)
        return this
    }

    fun setDouble(identifier: NBTIdentifier, value: Double): NBTItemExt {
        super.setDouble(identifier.toString(), value)
        return this
    }

    fun setObject(identifier: NBTIdentifier, value: Any): NBTItemExt {
        super.setObject(identifier.toString(), value)
        return this
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

    fun <T : Any> getObject(identifier: NBTIdentifier, kClass: KClass<T>): T {
        return super.getObject(identifier.toString(), kClass.java)
    }

    var displayName: String?
        set(displayName) {
            val meta = item.itemMeta
            meta.displayName = displayName
            item.itemMeta = meta
        }
        get() {
            return item.itemMeta.displayName
        }

    var meta: ItemMeta
        set(itemMeta) {
            item.itemMeta = itemMeta
        }
        get() {
            return item.itemMeta
        }


    fun addEnchantment(enchantment: Enchantment, level: Int = 1, ignoreLevelRestrictions: Boolean = true): NBTItemExt {
        val meta = item.itemMeta
        meta.addEnchant(enchantment, level, ignoreLevelRestrictions)
        item.itemMeta = meta
        return this
    }

    fun removeEnchantment(enchantment: Enchantment): NBTItemExt {
        val meta = item.itemMeta
        meta.removeEnchant(enchantment)
        item.itemMeta = meta
        return this
    }

    fun addItemFlags(vararg flags: ItemFlag): NBTItemExt {
        val meta = item.itemMeta
        meta.addItemFlags(*flags)
        item.itemMeta = meta
        return this
    }

    fun removeItemFlags(vararg flags: ItemFlag): NBTItemExt {
        val meta = item.itemMeta
        meta.removeItemFlags(*flags)
        item.itemMeta = meta
        return this
    }

    fun clone(): NBTItemExt {
        return NBTItemExt(item)
    }


    override fun toString(): String {
        return Objects.toStringHelper(this)
                .add("bukkitItem", item)
                .add("parent", parent)
                .toString()
    }

}