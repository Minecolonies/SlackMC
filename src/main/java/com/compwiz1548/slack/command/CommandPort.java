package com.compwiz1548.slack.command;

import com.compwiz1548.slack.handler.ConfigurationHandler;
import com.compwiz1548.slack.reference.Messages;
import com.compwiz1548.slack.reference.Names;
import com.compwiz1548.slack.reference.Settings;
import com.compwiz1548.slack.util.LogHelper;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;

public class CommandPort extends CommandBase {
    @Override
    public String getCommandName() {
        return Names.Settings.PORT;
    }

    @Override
    public String getCommandUsage(ICommandSender commandSender) {
        return Messages.Commands.PORT_COMMAND_USAGE;
    }

    @Override
    public void processCommand(ICommandSender commandSender, String[] args) {
        if (args.length < 2) {
            if (commandSender instanceof EntityPlayerMP) {
                commandSender.addChatMessage(new ChatComponentText(StatCollector.translateToLocal(Messages.Commands.PORT_COMMAND_USAGE)));
            }
            LogHelper.info(StatCollector.translateToLocal(Messages.Commands.PORT_COMMAND_USAGE));
        } else if (args[1].equals("reset")) {
            boolean success = ConfigurationHandler.setPort(25127);
            if (success) {
                if (commandSender instanceof EntityPlayerMP) {
                    commandSender.addChatMessage(new ChatComponentText(StatCollector.translateToLocal(Messages.Commands.PORT_COMMAND_RESET)));
                }
                LogHelper.info(StatCollector.translateToLocal(Messages.Commands.PORT_COMMAND_RESET));
            }
        } else {
            boolean success = ConfigurationHandler.setPort(Integer.parseInt(args[1]));
            if (success) {
                if (commandSender instanceof EntityPlayerMP) {
                    commandSender.addChatMessage(new ChatComponentText(String.format(StatCollector.translateToLocal(Messages.Commands.PORT_COMMAND_SUCCESS), Settings.port)));
                }
                LogHelper.info(String.format(StatCollector.translateToLocal(Messages.Commands.PORT_COMMAND_SUCCESS), Settings.port));
            }
        }
    }
}
