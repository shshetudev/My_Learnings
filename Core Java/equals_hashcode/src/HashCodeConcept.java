public class HashCodeConcept {
  public static void main(String... args) {
    Student shetu = new Student(1,"Shetu");
    Student motin = new Student(2, "Motin");
    boolean isHashCodeEquals = shetu.hashCode() == motin.hashCode();
    if(isHashCodeEquals) System.out.println("Should compare with equals method too");
    else System.out.println("Should not compare with equals() method, since id is different. This indicates that two objects are not same.");
  }

  static class Student {
    int id;
    String name;

    public Student(int id, String name) {
      this.id = id;
      this.name = name;
    }

    @Override
    public int hashCode() {
      return id;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;
      Student student = (Student) obj;
      return id == student.id && name.equals(student.name);
    }
  }
}
