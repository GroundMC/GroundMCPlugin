package gtlp.groundmc.lobby.util

import gtlp.groundmc.lobby.enums.Permission
import org.bukkit.command.CommandSender
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import java.util.logging.Logger
import kotlin.reflect.KClass

/**
 * Extension to [Logger] to use [Logger.exiting] with [KClass]es.
 *
 * @param kClass the class that the code is in
 * @param sourceMethod the method to log.
 */
fun Logger.exiting(kClass: KClass<*>, sourceMethod: String) {
    exiting(kClass.qualifiedName, sourceMethod)
}

/**
 * Extension to [Logger] to use [Logger.entering] with [KClass]es.
 *
 * @param kClass the class that the code is in
 * @param sourceMethod the method to log.
 */
fun Logger.entering(kClass: KClass<*>, sourceMethod: String) {
    entering(kClass.qualifiedName, sourceMethod)
}

/**
 * Extension to [MutableList].
 *
 * Sets the value at the specified index, if it exists.
 * Adds the value at the specified index, if it doesn't exist.
 *
 * @param index the index to set or add.
 * @param value the value to set.
 * @param E the type of the elements in this list.
 *
 * @return the list with the element set or added.
 */
fun <E> MutableList<E>.setOrAdd(index: Int, value: E): MutableList<E> {
    if (size > index) {
        this[index] = value
    } else {
        this.add(index, value)
    }
    return this
}

/**
 * Extension to [Inventory].
 *
 * Creates a real copy of the contents of an inventory.
 * This makes sure that changes to the inventory are not reflected in the
 * resulting array.
 *
 * @receiver the inventory you want the contents to be copied from
 * @return an array of the items in this inventory. Preserves `null`.
 */
fun Inventory.copy(): Array<ItemStack?> {
    val array = arrayOfNulls<ItemStack>(size)
    forEachIndexed { index: Int, item: ItemStack? ->
        if (item != null) {
            array[index] = item.clone()
        }
    }
    return array
}

/**
 * Extension to [CommandSender] that allows the use of our [Permission] enum
 * directly without pulling out the [Permission.permission] member.
 */
fun CommandSender.hasPermission(permission: Permission) = this.hasPermission(permission.permission)

/**
 * Extension to [Int] to convert the integer in megabytes to bytes.
 */
val Int.megabytes: Int
    get() = this * 1024.kilobytes

/**
 * Extension to [Int] to convert the integer in kilobytes to bytes.
 */
val Int.kilobytes: Int
    get() = this * 1024
