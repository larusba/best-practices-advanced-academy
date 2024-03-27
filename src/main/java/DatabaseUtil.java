import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {

    public Connection connectToDatabase() {
        return connectToDatabase("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
    }

    public Connection connectToDatabase(String jdbcUrl) {
        try {
            return DriverManager.getConnection(jdbcUrl, "sa", "");
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database: " + e.getMessage(), e);
        }
    }

    public void createTestTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE test_table (id INT PRIMARY KEY, name VARCHAR(255))");
        }
    }

    public void insertTestData(Connection connection, int id, String name) throws SQLException {
        try (PreparedStatement statement =
                connection.prepareStatement("INSERT INTO test_table VALUES (?, ?)")) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.execute();
        }
    }

    public String performQuery(Connection connection, String query) throws SQLException {
        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {

            if (resultSet.next()) {
                return resultSet.getString(1);
            } else {
                throw new SQLException("No result found");
            }
        }
    }

    public void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(
                    "Error closing the database connection: " + e.getMessage(), e);
        }
    }

    /*
        TODO - unit tests:

        import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.*;

    import java.sql.Connection;
    import java.sql.SQLException;

    public class EmbeddedDatabaseUtilTest {

        @Test
        public void testConnectToDatabase() {
            EmbeddedDatabaseUtil databaseUtil = new EmbeddedDatabaseUtil();

            // True Positive: Successfully connect to the embedded H2 database
            assertNotNull(databaseUtil.connectToDatabase());

            // Edge Case: Invalid JDBC URL
            assertThrows(IllegalArgumentException.class, () -> databaseUtil.connectToDatabase("invalid-jdbc-url"));
        }

        @Test
        public void testDatabaseOperations() {
            EmbeddedDatabaseUtil databaseUtil = new EmbeddedDatabaseUtil();

            // True Positive: Successfully perform database operations
            Connection connection = databaseUtil.connectToDatabase();
            assertNotNull(connection);

            try {
                // Create a test table
                databaseUtil.createTestTable(connection);

                // Insert data
                databaseUtil.insertTestData(connection, 1, "John Doe");

                // Perform query
                String result = databaseUtil.performQuery(connection, "SELECT name FROM test_table WHERE id = 1");
                assertEquals("John Doe", result);

            } catch (SQLException e) {
                fail("Exception during test: " + e.getMessage());
            } finally {
                databaseUtil.closeConnection(connection);
            }
        }
    }

         */
}
