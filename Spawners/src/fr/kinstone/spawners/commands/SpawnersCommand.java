package fr.kinstone.spawners.commands;

import fr.kinstone.spawners.SpawnersManager;
import fr.kinstone.spawners.settings.Lang;
import fr.kinstone.spawners.utils.command.Command;
import fr.kinstone.spawners.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class SpawnersCommand {

    @Command(name="spawners")
    public void onSpawnersCmd(CommandArgs args){

        Player player = args.getPlayer();

        player.sendMessage(Lang.PREFIX.get() + " " + Lang.NO_HAVE_SPAWNERS.get());

    }

}
