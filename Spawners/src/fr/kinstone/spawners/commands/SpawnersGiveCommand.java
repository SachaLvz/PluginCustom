package fr.kinstone.spawners.commands;

import fr.kinstone.spawners.SpawnersManager;
import fr.kinstone.spawners.utils.command.Command;
import fr.kinstone.spawners.utils.command.CommandArgs;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SpawnersGiveCommand {

    @Command(name="spawners.give", permission = "spawners.give", inGameOnly = true, usage = "/spawners give <Type> <Joueur>")
    public void onSpawnerGiveCmd(CommandArgs args){

        Player player = args.getPlayer();

        SpawnersManager.getSpawnersManager().addSpawnerToPlayer(player.getName(), EntityType.ZOMBIE);


    }

}
