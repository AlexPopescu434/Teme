package dataBase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class DatabaseQueryTest {
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

    @AfterAll
    public static void teardown() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    public void testQueryPrices() throws SQLException {
        String query = "SELECT accommodation.type, room_fair.value " +
                "FROM accommodation " +
                "JOIN accommodation_room_fair_relation ON accommodation.id = accommodation_room_fair_relation.accommodation_id " +
                "JOIN room_fair ON accommodation_room_fair_relation.room_fair_id = room_fair.id";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            boolean foundResults = false;

            System.out.println("Prețurile camerelor:");
            while (resultSet.next()) {
                foundResults = true;
                String accommodationType = resultSet.getString("type");
                double price = resultSet.getDouble("value");
                System.out.println("Tip cazare: " + accommodationType + ", Preț: " + price);
            }

            if (!foundResults) {
                throw new SQLException("The database is empty !");
            }
        }
    }
}