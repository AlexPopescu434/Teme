package dataBase;

import java.sql.*;

public class Main {
    public static void main(String[] args) {



        try {
            Class.forName("org.postgresql.Driver").newInstance();

            Connection connection = null;
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
                connection = DriverManager.getConnection(url);

                if (connection != null) {
                    System.out.println("Conectat la baza de date!");
                }

                // Afisati continutul tabelului 'accommodation'
                String selectAccommodationQuery = "SELECT * FROM accommodation";
                try (Statement statement = connection.createStatement();
                     ResultSet resultSet = statement.executeQuery(selectAccommodationQuery)) {
                    System.out.println("Tabelul 'accommodation':");
                    while (resultSet.next()) {
                        System.out.println("ID: " + resultSet.getInt("id") +
                                ", Type: " + resultSet.getString("type") +
                                ", Bed Type: " + resultSet.getString("bed_type") +
                                ", Max Guests: " + resultSet.getInt("max_guests") +
                                ", Description: " + resultSet.getString("description"));
                    }
                }

                // Afisati continutul tabelului 'room_fair'
                String selectRoomFairQuery = "SELECT * FROM room_fair";
                try (Statement statement = connection.createStatement();
                     ResultSet resultSet = statement.executeQuery(selectRoomFairQuery)) {
                    System.out.println("\nTabelul 'room_fair':");
                    while (resultSet.next()) {
                        System.out.println("ID: " + resultSet.getInt("id") +
                                ", Value: " + resultSet.getDouble("value") +
                                ", Season: " + resultSet.getString("season"));
                    }
                }

                // Afisati continutul tabelului 'accommodation_room_fair_relation'
                String selectRelationQuery = "SELECT * FROM accommodation_room_fair_relation";
                try (Statement statement = connection.createStatement();
                     ResultSet resultSet = statement.executeQuery(selectRelationQuery)) {
                    System.out.println("\nTabelul 'accommodation_room_fair_relation':");
                    while (resultSet.next()) {
                        System.out.println("ID: " + resultSet.getInt("id") +
                                ", Accommodation ID: " + resultSet.getInt("accommodation_id") +
                                ", Room Fair ID: " + resultSet.getInt("room_fair_id"));
                    }
                }

                connection.close();
            }
            catch (SQLException e) {
                System.err.println("Cannot connect to the database: " + e.getMessage());
            }

        }  catch (ClassNotFoundException  | RuntimeException | IllegalAccessException | InstantiationException e) {
            System.out.println("CANNOT LOAD DRIVER");
        }
      DatabaseErase.stergeElementeTabele();

    }
}
