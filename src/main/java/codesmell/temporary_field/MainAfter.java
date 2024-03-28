package codesmell.temporary_field;

public class MainAfter {
    static class CustomDateTime {
        private long year;
        private long month;
        private long day;
        // fullDate removed from fields

        public CustomDateTime(long year, long month, long day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public long getYear() {
            return year;
        }

        public long getMonth() {
            return month;
        }

        public long getDay() {
            return day;
        }

        @Override
        public String toString() {
            return getFullDate();
        }

        public String toOther() {
            return getFullDate() + ";";
        }

        private String getFullDate() {
            return year + ", " + month + ", " + day;
        }
    }

    public static void main(String[] args) {
        CustomDateTime customDateTime = new CustomDateTime(1999, 12, 12);
        long year = customDateTime.getYear();
        long month = customDateTime.getMonth();
        long day = customDateTime.getDay();
        // do stuff...
    }
}
