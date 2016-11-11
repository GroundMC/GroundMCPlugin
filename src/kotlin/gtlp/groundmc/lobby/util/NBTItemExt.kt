package gtlp.groundmc.lobby.util

import de.tr7zw.itemnbtapi.NBTItem
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
}