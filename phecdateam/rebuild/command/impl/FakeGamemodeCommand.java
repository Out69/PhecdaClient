package pl.oucik.phecdateam.rebuild.command.impl;

import net.minecraft.command.CommandBase;
import net.minecraft.command.NumberInvalidException;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldSettings.GameType;
import pl.oucik.phecdateam.rebuild.command.Command;
import pl.oucik.phecdateam.rebuild.command.CommandInfo;
import pl.oucik.phecdateam.rebuild.exception.CommandException;
import pl.oucik.phecdateam.rebuild.helper.ChatHelper;


@CommandInfo(
        alias = "fakegm",
        description = "Client spoofing your gamemode.",
        usage = ".fakegm <mode>",
        aliases = {"fakegm", "fgm"}
)
public class FakeGamemodeCommand extends Command {

    private GameType savedType;

    @Override
    public void execute(String... args) throws CommandException {
        if (args.length <= 0) {
            throw new CommandException(getUsage());
        }

        if (args[0].equalsIgnoreCase("revert") && savedType != null) {
            mc.playerController.setGameType(savedType);
            ChatHelper.printMessage("&cYour client gamemode was changed to &4" + savedType.getName());

            savedType = null;
        }

        try {
            GameType gameType = getGameModeFromCommand(args[0]);
            if (savedType == null) {
                savedType = mc.playerController.getCurrentGameType();
            }

            mc.playerController.setGameType(gameType);
            ChatHelper.printMessage("&cYour client gamemode was set to &4" + gameType.getName());
        } catch (Exception e) {
            throw new CommandException(getUsage());
        }
    }

    private WorldSettings.GameType getGameModeFromCommand(String argument)
            throws NumberInvalidException {
        return !argument.equalsIgnoreCase(WorldSettings.GameType.SURVIVAL.getName()) && !argument
                .equalsIgnoreCase("s")
                ? (!argument.equalsIgnoreCase(WorldSettings.GameType.CREATIVE.getName()) && !argument
                .equalsIgnoreCase("c")
                ? (!argument.equalsIgnoreCase(WorldSettings.GameType.ADVENTURE.getName()) && !argument
                .equalsIgnoreCase("a")
                ? (!argument.equalsIgnoreCase(WorldSettings.GameType.SPECTATOR.getName()) && !argument
                .equalsIgnoreCase("sp")
                ? WorldSettings.getGameTypeById(
                CommandBase.parseInt(argument, 0, WorldSettings.GameType.values().length - 2))
                : WorldSettings.GameType.SPECTATOR) : WorldSettings.GameType.ADVENTURE)
                : WorldSettings.GameType.CREATIVE) : WorldSettings.GameType.SURVIVAL;
    }
}
