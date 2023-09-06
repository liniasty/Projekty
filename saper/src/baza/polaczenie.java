package baza;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class polaczenie {
    public static void wyswietl() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Saper";
        String username = "root";
        String pass = "";
        int miejsce =1;
        Connection polacz=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            polacz = DriverManager.getConnection(url, username, pass);

            Statement statement = polacz.createStatement();
            ResultSet rezultat = statement.executeQuery("SELECT nick, wynik FROM ranking ORDER BY wynik");
            while (rezultat.next()) {
                System.out.println(miejsce+". "+ rezultat.getString(1) + " wynik: " + rezultat.getInt(2));
            miejsce++;
            }
            

        } catch (Exception e) {
            System.out.println(e);
        }finally {
			polacz.close();
		}
    }

    public static void przesli(String nick, int wynik) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Saper";
        String username = "root";
        String pass = "";
        Connection polacz=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            polacz = DriverManager.getConnection(url, username, pass);

            Statement statement = polacz.createStatement();
            ResultSet rezultat = statement.executeQuery("SELECT wynik FROM ranking WHERE nick='" + nick + "'");
            if (rezultat.next()) {
                if (wynik > rezultat.getInt(1)) {
                    statement.executeUpdate("UPDATE ranking SET wynik=" + wynik + " WHERE nick='" + nick + "'");
                }
            } else {
                statement.executeUpdate("INSERT INTO ranking (nick, wynik) VALUES ('" + nick + "', " + wynik + ")");
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }finally {
			polacz.close();
		}
    }
}
