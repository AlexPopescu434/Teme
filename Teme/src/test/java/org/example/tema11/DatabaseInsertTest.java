package dataBase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatabaseInsertTest {
    private static Connection connection;

    @BeforeAll

    public static void setup() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class.forName("org.postgresql.Driver").newInstance();

        DriverManager.setLoginTimeout(60);

        try {
            String url = new StringBuilder()
                    .append("jdbc:")
                    .append("postgresql")
                    .append("://")
                    .append("localhost")
                    .append(":")
                    .append(5432)
                    .append("/")
                    .append("DataB1")
                    .append("?user=")
                    .append("postgres")
                    .append("&password=")
                    .append("popes").toString();
            connection = DriverManager.getConnection(url); // Use the member variable, not local variable
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database: " + e.getMessage());
        }
    }

    // cleanup
    @AfterAll
    public static void teardown() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    public void testInsertData() throws SQLException {
        try {
            int accommodationId;
            int roomFairId;

            // Inserează o înregistrare în tabelul 'accommodation'
            String insertAccommodationQuery = "INSERT INTO accommodation (type, bed_type, max_guests, description) " +
                    "VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertAccommodationQuery, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, "TestHotel");
                preparedStatement.setString(2, "Single");
                preparedStatement.setInt(3, 1);
                preparedStatement.setString(4, "Test room");
                int rowsAffected = preparedStatement.executeUpdate();
                assertTrue(rowsAffected > 0);

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    accommodationId = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Failed to get generated ID for accommodation.");
                }
            }

            // Inserează o înregistrare în tabelul 'room_fair'
            String insertRoomFairQuery = "INSERT INTO room_fair (value, season) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertRoomFairQuery, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setDouble(1, 150.0);
                preparedStatement.setString(2, "Summer");
                int rowsAffected = preparedStatement.executeUpdate();
                assertTrue(rowsAffected > 0);

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    roomFairId = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Failed to get generated ID for room fair.");
                }
            }

            // Inserează o înregistrare în tabelul 'accommodation_room_fair_relation' pentru a crea legătura
            String insertRelationQuery = "INSERT INTO accommodation_room_fair_relation (accommodation_id, room_fair_id) " +
                    "VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertRelationQuery)) {
                preparedStatement.setInt(1, accommodationId);
                preparedStatement.setInt(2, roomFairId);
                int rowsAffected = preparedStatement.executeUpdate();
                assertTrue(rowsAffected > 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}