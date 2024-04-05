package exercises;

/**
 * TODO
 */
public class Exercise3After {
    // -- MySQL 
    public static class MySQLDatabase {
        public void connectMySQL() {
            System.out.println("Connecting to MySQL database");
        }

        public void queryMySQL(String query) {
            System.out.println("Executing query in MySQL database: " + query);
        }
    }

    // -- PostgreSQL
    public static class PostgreSQLDatabase {
        public void connectPostgreSQL() {
            System.out.println("Connecting to PostgreSQL database");
        }

        public void queryPostgreSQL(String query) {
            System.out.println("Executing query in PostgreSQL database: " + query);
        }
    }

    /**
     * Adapter
     */
    interface DatabaseAdapter {
        void connect();
        void query(String query);
    }

    // MySQL database adapter
    public static class MySQLDatabaseAdapterAdapter implements DatabaseAdapter {
        private MySQLDatabase mySQLDatabase;

        public MySQLDatabaseAdapterAdapter(MySQLDatabase mySQLDatabase) {
            this.mySQLDatabase = mySQLDatabase;
        }

        @Override
        public void connect() {
            mySQLDatabase.connectMySQL();
        }

        @Override
        public void query(String query) {
            mySQLDatabase.queryMySQL(query);
        }
    }

    // PostgreSQL database adapter
    public static class PostgreSQLDatabaseAdapterAdapter implements DatabaseAdapter {
        private PostgreSQLDatabase postgreSQLDatabase;

        public PostgreSQLDatabaseAdapterAdapter(PostgreSQLDatabase postgreSQLDatabase) {
            this.postgreSQLDatabase = postgreSQLDatabase;
        }

        @Override
        public void connect() {
            postgreSQLDatabase.connectPostgreSQL();
        }

        @Override
        public void query(String query) {
            postgreSQLDatabase.queryPostgreSQL(query);
        }
    }

    public static class Main {
        public static void main(String[] args) {
            // Using MySQL database through adapter
            DatabaseAdapter mySQLDatabaseAdapter = new MySQLDatabaseAdapterAdapter(new MySQLDatabase());
            mySQLDatabaseAdapter.connect();
            mySQLDatabaseAdapter.query("SELECT * FROM table");
        }
    }
}
