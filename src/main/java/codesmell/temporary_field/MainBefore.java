package codesmell.temporary_field;

public class MainBefore {
    static class CustomDateTime {
        private long year;
        private long month;
        private long day;
        
        // unused var, except for toString() 
        private String fullDate;

        public CustomDateTime(long year, long month, long day) {
            this.year = year;
            this.month = month;
            this.day = day;
            this.fullDate = year + ", " + month + ", " + day;
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

        
        public String toOther() {
            return fullDate + ";";
        }
        
        @Override
        public String toString() {
            return fullDate;
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
