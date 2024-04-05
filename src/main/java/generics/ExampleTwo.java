package generics;

import java.util.Objects;

public class ExampleTwo {

    public static void main(String[] args) {
        AnimalPrinter<Cat> animalPrinter1 = new AnimalPrinter<>(new Cat("Jim", "brown", 2));
        animalPrinter1.print();
        AnimalPrinter<Dog> animalPrinter2 = new AnimalPrinter<>(new Dog("Rocky", "black", 5));
        animalPrinter2.print();
    }

    public static class Cat extends Animal {
        public Cat(String name, String color, Integer age) {
            super(name, color, age);
        }
    }

    public static class Dog extends Animal {
        public Dog(String name, String color, Integer age) {
            super(name, color, age);
        }
    }

    /** T can be any class that extend Animal */
    public static class AnimalPrinter<T extends Animal> {
        private final T animalData;

        public AnimalPrinter(T animalData) {
            this.animalData = animalData;
        }

        public void print() {
            System.out.println("Name::: " + animalData.getName());
            System.out.println("Color::: " + animalData.getColor());
            System.out.println("Age::: " + animalData.getAge());
        }
    }

    public static class Animal {
        private final String name;
        private final String color;
        private final Integer age;

        public Animal(String name, String color, Integer age) {
            this.name = name;
            this.color = color;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getColor() {
            return color;
        }

        public Integer getAge() {
            return age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Animal animal = (Animal) o;
            return Objects.equals(name, animal.name)
                    && Objects.equals(color, animal.color)
                    && Objects.equals(age, animal.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, color, age);
        }
    }
}
