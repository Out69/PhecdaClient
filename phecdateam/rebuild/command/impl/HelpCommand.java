package pl.oucik.phecdateam.rebuild.command.impl;

import pl.oucik.phecdateam.PhecdaClient;
import pl.oucik.phecdateam.rebuild.command.Command;
import pl.oucik.phecdateam.rebuild.command.CommandInfo;
import pl.oucik.phecdateam.rebuild.exception.CommandException;
import pl.oucik.phecdateam.rebuild.helper.ChatHelper;

@CommandInfo(
        alias = "help"
)
public class HelpCommand extends Command {

    @Override
    public void execute(String... args) throws CommandException {
        if (args.length > 0) {
            ChatHelper.printMessage("\n", false);
            Command command = PhecdaClient.INSTANCE.getCommandManager().getCommand(args[0])
                    .orElseThrow(
                            () -> new CommandException(String.format("Command \"%s\" not found.\n", args[0])));

            ChatHelper
                    .printMessage(String.format("&5%s&f: &d%s", command.getAlias(), command.getUsage()));
            return;
        }
        ChatHelper.printMessage("--------------------------------------------------", false);
        ChatHelper.printMessage("\n", false);
        ChatHelper.printMessage("", false);
         PhecdaClient.INSTANCE.getCommandManager().getCommands().stream()
                .filter(command -> !(command instanceof HelpCommand))
                .forEach(command -> ChatHelper.printMessage(
                        String.format("&c%s &f- &4%s", command.getAlias(), command.getDescription())));
        ChatHelper.printMessage("\n", false);
        ChatHelper.printMessage("--------------------------------------------------", false);
        ChatHelper.printMessage("\n", false);
    }
}
