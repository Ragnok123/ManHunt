package ru.ragnok123.manhunt;

import cn.nukkit.Player;
import cn.nukkit.utils.TextFormat;
import ru.ragnok123.minigameAPI.player.GamePlayer;

public class MHPlayer extends GamePlayer {
	
	private String originalDisplayName;
	
	public MHPlayer(Player player) {
		super(player);
		this.originalDisplayName = player.getDisplayName();
	}

	@Override
	public String getGameNick() {
		return "";
	}

	@Override
	public void setupLobbyDisplayName() {
		this.player.setDisplayName(this.originalDisplayName);
	}

	@Override
	public void setupTeamDisplayName(TextFormat color) {

	}

	@Override
	public void loadData() {

	}

	@Override
	public void createData() {

	}

	@Override
	public void save() {

	}

}
