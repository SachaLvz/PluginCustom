package fr.kinstone.spawners;

import fr.kinstone.spawners.commands.SpawnersCommand;
import fr.kinstone.spawners.commands.SpawnersGiveCommand;
import fr.kinstone.spawners.settings.SettingsManager;
import fr.kinstone.spawners.utils.command.CommandFramework;
import fr.kinstone.spawners.utils.json.JsonFramework;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class SpawnersPlugin extends JavaPlugin {

    @Getter
    static SpawnersPlugin instance;

    @Getter
    CommandFramework commandFramework;

    @Getter
    JsonFramework jsonFramework;

    @Getter
    SpawnersManager spawnersManager;

    @Getter
    SettingsManager settingsManager;

    @Override
    public void onEnable() {

        instance = this;

        getLogger().info("********************************");
        getLogger().info("Plugin initializing");

        getDataFolder().mkdir();

        settingsManager = new SettingsManager();
        settingsManager.loadFiles();

        registerCommands();

        jsonFramework = new JsonFramework(this);
        jsonFramework.addPersist(new SpawnersManager());
        jsonFramework.loadAllData();

        spawnersManager = new SpawnersManager();

        getLogger().info("********************************");

    }

    @Override
    public void onDisable() {

        jsonFramework.saveAllData(true);

    }

    public void registerCommands(){

        commandFramework = new CommandFramework(this);
        commandFramework.registerCommands(new SpawnersCommand());
        commandFramework.registerCommands(new SpawnersGiveCommand());

    }

}
