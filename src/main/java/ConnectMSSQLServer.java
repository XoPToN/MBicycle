
import java.sql.*;
import java.util.Scanner;

public class ConnectMSSQLServer {
    public static void main(String[] args) throws ClassNotFoundException {
        String name = "sa";
        String password = "01380206";
        String url = "jdbc:sqlserver://localhost\\МИХАИЛ-ПК:1433;database=Savchenko_BookAndAuthors";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try {
            Connection conn = DriverManager.getConnection(url, name, password);
            Statement statement = conn.createStatement();
            System.out.println("Введите фамилию автора ");
            Scanner inputStr = new Scanner(System.in);
            String str = inputStr.nextLine();
            ResultSet resultSet = statement.executeQuery("select * from books where idB \n" +
                    "in(select id_book from storage where id_authors\n" +
                    "in(select idA from authors where nameA='" + str + "'))");
            System.out.println(str + " написал следущие книги : ");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("nameB"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
//jdbc:sqlserver://localhost\МИХАИЛ-ПК:1433;database=Savchenko_BookAndAuthors
