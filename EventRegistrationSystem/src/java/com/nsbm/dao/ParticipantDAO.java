package com.nsbm.dao;

import com.nsbm.model.Participant;
import java.sql.*;
import java.util.*;
/**
 *
 * @author IsuruKumara
 */
public class ParticipantDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/eventdb";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "";


    private static final String INSERT_SQL = "INSERT INTO participants (name, email, event) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_SQL = "SELECT * FROM participants";

    protected Connection getConnection() {
    Connection conn = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    } catch (ClassNotFoundException e) {
        System.out.println("MySQL JDBC Driver not found.");
        e.printStackTrace();
    } catch (SQLException e) {
        System.out.println("Connection failed: " + e.getMessage());
        e.printStackTrace();
    }
    return conn;
}


    public void insertParticipant(Participant participant) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {
            stmt.setString(1, participant.getName());
            stmt.setString(2, participant.getEmail());
            stmt.setString(3, participant.getEvent());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Participant> listParticipants() {
        List<Participant> list = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_SQL);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Participant p = new Participant();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setEmail(rs.getString("email"));
                p.setEvent(rs.getString("event"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
