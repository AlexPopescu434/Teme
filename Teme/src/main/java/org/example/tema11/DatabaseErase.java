package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseErase { // Stergerea elementelor din tabele si resetarea id-urilor la  valoarea 1.

    public static void stergeElementeTabele(){
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



        // Șterge înregistrările din tabelul 'accommodation_room_fair_relation'
                String deleteRelationQuery = "DELETE FROM accommodation_room_fair_relation ";
           try (Statement statement = connection.createStatement()) {
               statement.executeUpdate(deleteRelationQuery);
               System.out.println("Datele au fost șterse din tabelul 'accommodation_room_fair_relation'.");
           }

        //  Șterge toate înregistrările din tabelul 'accommodation'
          String deleteAccommodationQuery = "DELETE FROM accommodation";
          try (Statement statement = connection.createStatement()) {
              statement.executeUpdate(deleteAccommodationQuery);
              System.out.println("Datele au fost șterse din tabelul 'accommodation'.");
          }

        // Șterge toate înregistrările din tabelul 'room_fair'
           String deleteroom_fairQuery = "DELETE FROM room_fair";
           try (Statement statement = connection.createStatement()) {
               statement.executeUpdate(deleteroom_fairQuery);
               System.out.println("Datele au fost șterse din tabelul 'room_fair'.");
           }

        // Resetează ID-urile auto-incrementale
           String resetIdAccommodationQuery = "SELECT setval('accommodation_id_seq', 1, false)";
           try (Statement statement = connection.createStatement()) {
               statement.execute(resetIdAccommodationQuery);
           }

           String resetIdRoomFairQuery = "SELECT setval('room_fair_id_seq', 1, false)";
           try (Statement statement = connection.createStatement()) {
               statement.execute(resetIdRoomFairQuery);
           }

           String resetIdRelationQuery = "SELECT setval('accommodation_room_fair_relation_id_seq', 1, false)";
           try (Statement statement = connection.createStatement()) {
              statement.execute(resetIdRelationQuery);
           }

        System.out.println("ID-urile au fost resetate.");

                connection.close();
            }
            catch (SQLException e) {
                System.err.println("Cannot connect to the database: " + e.getMessage());
            }

        }  catch (ClassNotFoundException  | RuntimeException | IllegalAccessException | InstantiationException e) {
            System.out.println("CANNOT LOAD DRIVER");
        }
    }
}

