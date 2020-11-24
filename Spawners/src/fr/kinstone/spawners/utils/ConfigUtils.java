package fr.kinstone.spawners.utils;

import fr.kinstone.spawners.SpawnersPlugin;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigUtils {

    public static void createFile(String fileName){

         File file = new File(SpawnersPlugin.getInstance().getDataFolder(), fileName);

         if(!file.exists()){
             try {
                 file.createNewFile();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
    }

    public static YamlConfiguration getConfig(String fileName){

        File file = new File(SpawnersPlugin.getInstance().getDataFolder(), fileName);
        if(!file.exists())
            return null;
        return YamlConfiguration.loadConfiguration(file);

    }



}
