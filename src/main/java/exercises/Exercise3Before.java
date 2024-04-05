package exercises;

/**
 * EX: try to refactor these 2 databases Classes, 
 * in order to use method names common to both
 */
public class Exercise3Before {
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

    public class Main {
        public static void main(String[] args) {
            // Using MySQL database
            MySQLDatabase mySQLDatabase = new MySQLDatabase();
            mySQLDatabase.connectMySQL();
            mySQLDatabase.queryMySQL("SELECT * FROM table");

            // Using PostgreSQL database
            PostgreSQLDatabase postgreSQLDatabase = new PostgreSQLDatabase();
            postgreSQLDatabase.connectPostgreSQL();
            postgreSQLDatabase.queryPostgreSQL("SELECT * FROM table");
        }
    }

}
