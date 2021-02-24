package com.webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepositoryImpl implements PlayerRepository {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	public PlayerRepositoryImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/World?" + "user=root&password=v3ry$3cur3PASSWORD");
			stmt = conn.createStatement();

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void createTable() {
		String sql = "create table Player(playerid varchar(20),playername varchar(100),country varchar(100),"
				+ "sports varchar(100), primary key(playerid))";

		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean addPlayer(Player player) {

		String sql = "insert into Player values(" + "\"" + player.getPlayerid() + "\"" + ",\"" + player.getPlayername()
				+ "\"" + ",\"" + player.getCountry() + "\"" + ",\"" + player.getSports() + "\"" + ")";

		System.out.println(sql);
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Player> getAllPlayersByCountry(String country) {
		return null;
	}

	@Override
	public List<Player> getAllPlayers() {
		List<Player> playerlist = new ArrayList<>();
		try {
			rs = stmt.executeQuery("select * from Player");
			while (rs.next()) {
				Player player = new Player(rs.getString("playerid"), rs.getString("playername"),
						rs.getString("country"), rs.getString("sports"));
				playerlist.add(player);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return playerlist;
	}

	@Override
	public boolean deletePlayer(String playerid) {
		String sql = "Delete from Player where id=" + playerid;

		System.out.println(sql);
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}