package gtlp.groundmc.lobby;

import com.github.gianttreelp.bukkitdependencyloader.DependencyLoader;
import com.github.gianttreelp.bukkitdependencyloader.DependencyLoaderPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

public class LobbyLoader extends JavaPlugin {

    private LobbyMain plugin;

    @Override
    public void onEnable() {
        DependencyLoader loader = DependencyLoaderPlugin.forPlugin(this);
        loader.addRepository("bintray-kotlin-exposed", "http://dl.bintray.com/kotlin/exposed");
        loader.loadArtifact("joda-time", "joda-time", "2.9.9");
        loader.loadArtifact("com.h2database", "h2", "1.4.194");
        loader.loadArtifact("org.jetbrains.exposed", "exposed", "0.7.6");
        loader.loadArtifact("org.jetbrains.kotlin", "kotlin-stdlib", "1.1.1");
        loader.loadArtifact("org.jetbrains.kotlin", "kotlin-reflect", "1.1.1");
        loader.loadArtifact("org.slf4j", "slf4j-jdk14", "1.7.25");

        try {
            Class<?> clazz = getClassLoader().loadClass("org.bukkit.plugin.java.PluginClassLoader");
            Field fPlugin = clazz.getDeclaredField("plugin");
            fPlugin.setAccessible(true);

            Field fModifiers = Field.class.getDeclaredField("modifiers");
            fModifiers.setAccessible(true);
            fModifiers.setInt(fPlugin, fPlugin.getModifiers() & ~Modifier.FINAL);

            fPlugin.set(getClassLoader(), null);
            Field fPluginInit = clazz.getDeclaredField("pluginInit");
            fPluginInit.setAccessible(true);
            fPluginInit.set(getClassLoader(), null);
            plugin = new LobbyMain();
            Bukkit.getPluginManager().enablePlugin(plugin);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return plugin.onCommand(sender, command, label, args);
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return plugin.onTabComplete(sender, command, alias, args);
    }

    @Override
    public void onDisable() {
        plugin.onDisable();
    }

    @Override
    public void saveConfig() {
        plugin.saveConfig();
    }
}
