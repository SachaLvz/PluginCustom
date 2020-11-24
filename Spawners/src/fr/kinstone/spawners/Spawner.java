package fr.kinstone.spawners;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;

@Getter @Setter
public class Spawner {

    private int id;
    private String owner;
    private Location spawnerLocation;
    private EntityType entityType;
    private boolean isPlaced;

    public Spawner(String owner, EntityType entityType) {
        this.id = SpawnersPlugin.getInstance().getSpawnersManager().getSpawnersManager().getSpawnerList().size() + 1;
        this.owner = owner;
        this.entityType = entityType;
    }
}
