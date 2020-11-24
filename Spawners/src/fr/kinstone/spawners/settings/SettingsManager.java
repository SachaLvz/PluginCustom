package fr.kinstone.spawners.settings;

import fr.kinstone.spawners.SpawnersPlugin;
import fr.kinstone.spawners.utils.ConfigUtils;
import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

@Getter
public class SettingsManager {

    private FileConfiguration configFile;
    private FileConfiguration langFile;

    public void loadFiles(){

       SpawnersPlugin.getInstance().saveConfig();
       configFile = SpawnersPlugin.getInstance().getConfig();

       File messageFile = new File(SpawnersPlugin.getInstance().getDataFolder(), "messages.yml");

       if(!messageFile.exists()) {
           try {
               messageFile.createNewFile();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }

       langFile = YamlConfiguration.loadConfiguration(messageFile);


    }

    public void saveFile(){

    }



}
