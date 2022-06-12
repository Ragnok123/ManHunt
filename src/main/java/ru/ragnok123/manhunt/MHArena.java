package ru.ragnok123.manhunt;

import cn.nukkit.Player;
import cn.nukkit.Server;
import ru.ragnok123.minigameAPI.arena.ArenaManager;
import ru.ragnok123.minigameAPI.arena.ArenaParameters;
import ru.ragnok123.minigameAPI.arena.IArena;
import ru.ragnok123.minigameAPI.player.GamePlayer;

public class MHArena extends IArena{
	
	public Player runner = null;

	public MHArena(ArenaManager manager, ArenaParameters params, Integer arenaId) {
		super(manager, params, arenaId);
	}

	@Override
	public void selectLevel() {
		// do nothing
		
	}

	@Override
	public void loadArenaLevel() {
		// do nothing
		
	}

	@Override
	public int getMinPlayers() {
		return 2;
	}

	@Override
	public int getMaxPlayers() {
		return Server.getInstance().getMaxPlayers();
	}

	@Override
	public void initGameData(GamePlayer p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processSpawn(Player p) {
		// TODO Auto-generated method stub
		
	}

}
