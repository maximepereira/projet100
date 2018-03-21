package daos;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;

public class DataSourceProvider {

    private static MysqlDataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setServerName("gi6kn64hu98hy0b6.chr7pe7iynqr.eu-west-1.rds.amazonaws.com");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("p4hx4a0gkvtfnqz9");
            dataSource.setUser("gx3kxtd7wkr2zgtr");
            dataSource.setPassword("ak5zcpoal9rpk6f1");
        }
        return dataSource;
    }
}
  