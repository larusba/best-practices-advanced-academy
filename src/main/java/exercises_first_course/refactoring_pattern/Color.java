package exercises_first_course.refactoring_pattern;

public enum Color {
    WHITE("W"),
    BLACK("B");

    private String colorString;

    Color(String colorString) {
        this.colorString = colorString;
    }

    @Override
    public String toString() {
        return colorString;
    }
}
