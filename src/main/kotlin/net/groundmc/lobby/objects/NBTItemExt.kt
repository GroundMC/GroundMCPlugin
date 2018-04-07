package net.groundmc.lobby.objects

import com.google.common.base.MoreObjects
import de.tr7zw.itemnbtapi.NBTItem
import net.groundmc.lobby.enums.NBTIdentifier
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import kotlin.reflect.KClass

/**
 * Extension of [de.tr7zw.itemnbtapi.NBTItem]
 * Allows the use of [NBTIdentifier] as a key.
 */
@Suppress("unused")
class NBTItemExt(item: ItemStack) : NBTItem(item), Cloneable {

    constructor(material: Material) : this(ItemStack(material))

    /**
     * Sets an integer value for a key.
     *
     * @param identifier the identifier of this value.
     * @param value the integer value to set
     *
     * @return this item to allow chaining
     *
     * @see NBTItem.setInteger
     */
    fun setInteger(identifier: NBTIdentifier, value: Int): NBTItemExt {
        super.setInteger(identifier.toString(), value)
        return this
    }

    /**
     * Sets a boolean value for a key.
     *
     * @param identifier the identifier of this value.
     * @param value the boolean value to set
     *
     * @return this item to allow chaining
     *
     * @see NBTItem.setBoolean
     */
    fun setBoolean(identifier: NBTIdentifier, value: Boolean): NBTItemExt {
        super.setBoolean(identifier.toString(), value)
        return this
    }

    /**
     * Sets a string value for a key.
     *
     * @param identifier the identifier of this value.
     * @param value the string value to set
     *
     * @return this item to allow chaining
     *
     * @see NBTItem.setString
     */
    fun setString(identifier: NBTIdentifier, value: String): NBTItemExt {
        super.setString(identifier.toString(), value)
        return this
    }

    /**
     * Sets a double value for a key.
     *
     * @param identifier the identifier of this value.
     * @param value the double value to set
     *
     * @return this item to allow chaining
     *
     * @see NBTItem.setDouble
     */
    fun setDouble(identifier: NBTIdentifier, value: Double): NBTItemExt {
        super.setDouble(identifier.toString(), value)
        return this
    }

    /**
     * Sets a object value for a key.
     *
     * @param identifier the identifier of this value.
     * @param value the object value to set
     *
     * @return this item to allow chaining
     *
     * @see NBTItem.setObject
     */
    fun setObject(identifier: NBTIdentifier, value: Any): NBTItemExt {
        super.setObject(identifier.toString(), value)
        return this
    }

    /**
     * Checks whether this item has a key with a value mapped to it.
     *
     * @param identifier the identifier to check for.
     *
     * @return whether a key by [identifier] exists.
     */
    fun hasKey(identifier: NBTIdentifier): Boolean =
            super.hasKey(identifier.toString())

    /**
     * Removes a key-value pair from this item
     *
     * @param identifier the identifier to remove the pair for.
     */
    fun removeKey(identifier: NBTIdentifier) {
        super.removeKey(identifier.toString())
    }

    /**
     * Gets an integer value for an identifier
     *
     * @param identifier the key to get the value for
     *
     * @return the integer that is mapped to the [identifier]
     *
     * @see NBTItem.getInteger
     */
    fun getInteger(identifier: NBTIdentifier): Int? =
            super.getInteger(identifier.toString())

    /**
     * Gets a boolean value for an identifier
     *
     * @param identifier the key to get the value for
     *
     * @return the boolean that is mapped to the [identifier]
     *
     * @see NBTItem.getBoolean
     */
    fun getBoolean(identifier: NBTIdentifier): Boolean? =
            super.getBoolean(identifier.toString())

    /**
     * Gets a string value for an identifier
     *
     * @param identifier the key to get the value for
     *
     * @return the string that is mapped to the [identifier]
     *
     * @see NBTItem.getString
     */
    fun getString(identifier: NBTIdentifier): String? =
            super.getString(identifier.toString())

    /**
     * Gets a double value for an identifier
     *
     * @param identifier the key to get the value for
     *
     * @return the double that is mapped to the [identifier]
     *
     * @see NBTItem.getDouble
     */
    fun getDouble(identifier: NBTIdentifier): Double? =
            super.getDouble(identifier.toString())

    /**
     * Gets an object value for an identifier
     *
     * @param identifier the key to get the value for
     *
     * @return the object that is mapped to the [identifier]
     *
     * @see NBTItem.getObject
     */
    fun <T : Any> getObject(identifier: NBTIdentifier, kClass: KClass<T>): T? =
            super.getObject(identifier.toString(), kClass.java)

    /**
     * The displayed name for this item.
     * This member allows easy read and write access.
     */
    var displayName: String?
        set(displayName) {
            val meta = item.itemMeta
            meta.displayName = displayName
            item.itemMeta = meta
        }
        get() = item.itemMeta.displayName

    /**
     * The metadata of this item.
     * This member allows easy read and write access.
     */
    var meta: ItemMeta
        set(itemMeta) {
            item.itemMeta = itemMeta
        }
        get() = item.itemMeta

    /**
     * The lore of this item.
     * This member allow easy read and write access.
     */
    var lore: MutableList<String>
        set(lore) {
            val meta = item.itemMeta
            meta.lore = lore
            item.itemMeta = meta
        }
        get() = if (meta.hasLore()) item.itemMeta.lore else mutableListOf()


    /**
     * Adds the specified enchantment to this item meta.
     *
     * @param enchantment Enchantment to add
     * @param level Level for the enchantment
     * @param ignoreLevelRestrictions this indicates the enchantment should be
     *     applied, ignoring the level limit
     *
     * @return this item to allow chaining
     *
     * @see ItemMeta.addEnchant
     */
    fun addEnchantment(enchantment: Enchantment, level: Int = 1, ignoreLevelRestrictions: Boolean = true): NBTItemExt {
        val meta = item.itemMeta
        meta.addEnchant(enchantment, level, ignoreLevelRestrictions)
        item.itemMeta = meta
        return this
    }

    /**
     * Removes the specified enchantment from this item meta.
     *
     * @param enchantment Enchantment to remove
     *
     * @return this item to allow chaining
     */
    fun removeEnchantment(enchantment: Enchantment): NBTItemExt {
        val meta = item.itemMeta
        meta.removeEnchant(enchantment)
        item.itemMeta = meta
        return this
    }

    /**
     * Adds flags to this item.
     *
     * @param flags the flags to add
     *
     * @return this item to allow chaining
     *
     * @see ItemMeta.addItemFlags
     */
    fun addItemFlags(vararg flags: ItemFlag): NBTItemExt {
        val meta = item.itemMeta
        meta.addItemFlags(*flags)
        item.itemMeta = meta
        return this
    }

    /**
     * Removes flags to this item.
     *
     * @param flags the flags to remove
     *
     * @return this item to allow chaining
     *
     * @see ItemMeta.removeItemFlags
     */
    fun removeItemFlags(vararg flags: ItemFlag): NBTItemExt {
        val meta = item.itemMeta
        meta.removeItemFlags(*flags)
        item.itemMeta = meta
        return this
    }

    /**
     * Clones this item by creating a new instance of this item.
     *
     * @return a clone of this item.
     */
    public override fun clone(): NBTItemExt = NBTItemExt(item)

    /**
     * Creates a string representation of this item.
     *
     * @return the string representation of this item.
     */
    override fun toString(): String {
        return MoreObjects.toStringHelper(this)
                .add("bukkitItem", item)
                .add("parent", parent)
                .toString()
    }

}
