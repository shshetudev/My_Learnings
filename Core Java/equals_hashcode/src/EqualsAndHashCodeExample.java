public class EqualsAndHashCodeExample {
  public static void main(String... args) {
    System.out.println(
      new Person("Shahariar", 28, 100)
        .equals(new Person("Shahariar", 28, 100))
    );
    System.out.println(
      new Person("Motin", 30, 65)
        .equals(new Person("Motin", 30, 65))
    );
    System.out.println(
      new Person("Shawkat", 30, 65)
        .equals(new Person("Shawkat", 30, 65))
    );
  }

  static class Person {
    private String name;
    private int age;
    private int weight;

    public Person(String name, int age, int weight) {
      this.name = name;
      this.age = age;
      this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;
      Person person = (Person) obj;
      return age == person.age && weight == person.weight && name.equals(person.name);
    }
  }
}
