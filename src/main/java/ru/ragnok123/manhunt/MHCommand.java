package ru.ragnok123.manhunt;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

class MHCommand extends Command{

	public MHCommand(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args) {
		Player p = (Player)sender;
		MHPlayer d = (MHPlayer) ManHuntMinigame.getPlayer(p.getName());
		if(args[0].equalsIgnoreCase("runner")) {
			Player target = Server.getInstance().getPlayer(args[1]);
			((MHArena) d.getArena()).runner = target;
		}
		return false;
	}
	
	
}