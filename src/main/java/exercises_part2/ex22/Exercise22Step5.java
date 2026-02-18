package exercises_part2.ex22;

public class Exercise22Step5 {
    public static class EnvConfig implements Exercise22Step3.ConfigProvider {
        @Override
        public String getDbUrl() {
            String envUrl = System.getenv("DB_URL");
            return (envUrl != null) ? envUrl : "jdbc:default";
        }
    }
}