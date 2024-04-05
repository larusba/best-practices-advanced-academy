package exercises;

/**
 * Pattern Adapter
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
    
    // Adapter interface
    interface Database {
        void connect();
        void query(String query);
    }

    public static class MySQLDatabaseAdapter implements Database {
        private MySQLDatabase mySQLDatabase;

        public MySQLDatabaseAdapter(MySQLDatabase mySQLDatabase) {
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

    public static class PostgreSQLDatabaseAdapter implements Database {
        private PostgreSQLDatabase postgreSQLDatabase;

        public PostgreSQLDatabaseAdapter(PostgreSQLDatabase postgreSQLDatabase) {
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
            Database mySQLDatabaseAdapter = new MySQLDatabaseAdapter(new MySQLDatabase());
            mySQLDatabaseAdapter.connect();
            mySQLDatabaseAdapter.query("SELECT * FROM table");

            // Using PostgreSQL database through adapter
            Database postgreSQLDatabaseAdapter = new PostgreSQLDatabaseAdapter(new PostgreSQLDatabase());
            postgreSQLDatabaseAdapter.connect();
            postgreSQLDatabaseAdapter.query("SELECT * FROM table");
        }
    }

}
