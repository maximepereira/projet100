package daos;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import pojos.Categorie;



import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategorieDao {

    public DataSource getDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName("gi6kn64hu98hy0b6.chr7pe7iynqr.eu-west-1.rds.amazonaws.com");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("p4hx4a0gkvtfnqz9");
        dataSource.setUser("gx3kxtd7wkr2zgtr");
        dataSource.setPassword("ak5zcpoal9rpk6f1");
        return dataSource;
    }

    public List<Categorie> listCategorie(){
        List<Categorie> categories = new ArrayList<>();
        try(Connection connection = getDataSource().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM categorie")){
            while(resultSet.next()) {
                categories.add(new Categorie(
                        resultSet.getInt("idCategorie"),
                        resultSet.getString("nomCategorie")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public void addCategorie(String nomCategorie) {
        String query = "INSERT INTO categorie (nomCategorie) VALUES(?)";
        try (Connection connection = getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nomCategorie);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Categorie getCategorie(String nomCategorie){
        String query = "SELECT * FROM categorie WHERE nomCategorie=?";
        try (Connection connection = getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nomCategorie);
            statement.executeQuery();
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Categorie(resultSet.getInt("idCategorie"), resultSet.getString("nomCategorie"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
