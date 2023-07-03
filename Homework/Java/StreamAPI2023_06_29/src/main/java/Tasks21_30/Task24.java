package Tasks21_30;

import java.util.Comparator;
import java.util.List;

public class Task24 {

    // Дан список объектов Person с полем "возраст". Необходимо отфильтровать объекты,
    // возраст которых находится в диапазоне от 25 до 40 лет, отсортировать по имени и вывести результат.

    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("Anna", 24),
                new Person("Max", 28),
                new Person("Ivan", 45),
                new Person("Vlad", 26),
                new Person("Georg", 26),
                new Person("Petya", 18)
        );

        personList.stream()
                .filter(person -> person.age >= 25 && person.age <= 40)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }

    private static class Person {
        private final String name;
        public int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
