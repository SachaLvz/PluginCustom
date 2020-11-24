package fr.kinstone.spawners;

import fr.kinstone.spawners.commands.SpawnersCommand;
import fr.kinstone.spawners.commands.SpawnersGiveCommand;
import fr.kinstone.spawners.utils.DiscUtil;
import fr.kinstone.spawners.utils.json.JsonFramework;
import fr.kinstone.spawners.utils.json.JsonPersist;
import lombok.Getter;
import net.minecraft.util.com.google.common.reflect.TypeToken;
import org.bukkit.entity.EntityType;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SpawnersManager implements JsonPersist {

    @Getter
    private SpawnersManager spawnersManager;

    @Getter
    private List<Spawner> spawnerList = new ArrayList<>();

    public SpawnersManager(){

        spawnersManager = this;

        SpawnersPlugin.getInstance().getCommandFramework().registerCommands(new SpawnersCommand());
        SpawnersPlugin.getInstance().getCommandFramework().registerCommands(new SpawnersGiveCommand());

    }

    @Override
    public File getFile() {return new File(SpawnersPlugin.getInstance().getDataFolder(), "spawners.json");}

    public void loadData()
    {
        String content = DiscUtil.readCatch(getFile());
        if (content == null) {
            return;
        }
        List<Spawner> spawners = (List) JsonFramework.getJsonFramework().getGson().fromJson(content, new TypeToken<List<Spawner>>() {}.getType());
        if ((spawners != null) && (!spawners.isEmpty())) {
            this.spawnerList.addAll(spawners);
        }
    }

    @Override
    public void saveData(boolean sync) {
        DiscUtil.writeCatch(getFile(), JsonFramework.getJsonFramework().getGson().toJson(this.spawnerList), sync);
    }

    public void loadConfiguration(){

    }

    public List<Spawner> getPlayerSpawners(String player){
        return spawnerList.stream().filter(spawner -> spawner.getOwner() == player).collect(Collectors.toList());
    }

    public Spawner getPlayerSpawnerById(int id){
        return spawnerList.stream().filter(spawner -> spawner.getId() == id).findFirst().orElse(null);
    }

    public void addSpawnerToPlayer(String owner, EntityType entityType){

        Spawner spawner = new Spawner(owner, entityType);
        spawnerList.add(spawner);

    }

    public void removePlayerSpawner(String player){


    }

}
