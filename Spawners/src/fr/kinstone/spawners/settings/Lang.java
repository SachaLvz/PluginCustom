package fr.kinstone.spawners.settings;

import fr.kinstone.spawners.SpawnersPlugin;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;

public enum Lang {

    PREFIX,
    NO_HAVE_SPAWNERS;

    private static final Map<Lang, String> LANG_VALUES = new HashMap<>();

    static {

        for(Lang lang : values()){
            LANG_VALUES.put(lang, lang.getStringFromFile());
        }
    }

    public String get(){
        return LANG_VALUES.get(this);
    }

    private String getStringFromFile(){

        FileConfiguration message = SpawnersPlugin.getInstance().getSettingsManager().getLangFile();
        String key = name().toLowerCase().replace('_', '-');
        String value = message.getString(key);

        if(value == null) value = "";

        return ChatColor.translateAlternateColorCodes('&', value);

    }

}
