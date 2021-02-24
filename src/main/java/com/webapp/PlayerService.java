package com.webapp;

import java.util.List;

public class PlayerService {

	PlayerRepositoryImpl playerRepositoryImpl = new PlayerRepositoryImpl();

	public boolean addPlayer(Player player) {
		playerRepositoryImpl.addPlayer(player);
		return true;
	}

	public List<Player> getAllPlayersByCountry(String country) {
		List<Player> playerlist = playerRepositoryImpl.getAllPlayersByCountry(country);
		return playerlist;
	}

	public List<Player> getAllPlayers() {
		List<Player> playerlist = playerRepositoryImpl.getAllPlayers();
		return playerlist;
	}

	public boolean deletePlayer(String playerid) {
		playerRepositoryImpl.deletePlayer(playerid);
		return true;
	}

	public void createTable() {
		playerRepositoryImpl.createTable();
	}

}
