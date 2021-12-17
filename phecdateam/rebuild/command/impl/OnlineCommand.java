package pl.oucik.phecdateam.rebuild.command.impl;

import pl.oucik.phecdateam.rebuild.command.Command;
import pl.oucik.phecdateam.rebuild.command.CommandInfo;
import pl.oucik.phecdateam.rebuild.exception.CommandException;
import pl.oucik.phecdateam.rebuild.helper.ChatHelper;
import pl.oucik.phecdateam.rebuild.helper.PlayerHelper;


@CommandInfo(
    alias = "players",
    description = "Real online players on server",
    usage = ".players ",
    aliases = {"players", "realplayers"}
)
public class OnlineCommand extends Command {

  @Override
  public void execute(String... args) throws CommandException {
    Type type = args.length > 0 ? Type.valueOf(args[0].toUpperCase()) : Type.PLAYER_DATA;
    int onlinePlayers = -1;

    switch (type) {
      case PLAYER_DATA:
        onlinePlayers = PlayerHelper.getOnlinePlayer().size();
        break;
      case TAB_COMPLETE:
        //TODO: LOL I'M LAZY AS FUK
        break;
    }

    ChatHelper.printMessage("&cOnline players: &4" + onlinePlayers);
  }

  enum Type {
    TAB_COMPLETE, PLAYER_DATA
  }
}
