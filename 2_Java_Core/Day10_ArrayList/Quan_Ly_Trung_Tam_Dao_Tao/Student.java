package Day10_ArrayList.Quan_Ly_Trung_Tam_Dao_Tao;

public class Student {
    private String id;
    private String name;
    private int age;
    private String rank;

    // Constructor
    public Student(String id, String name, int age, String rank) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.rank = rank;
    }

    // Getter and Setter
    public String getId() {
        return this.id;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }

    // Display Student info
    public void display() {
        System.out.println("\tid: " + id + " - name: " + name + " - age: " + age + " - rank: " + rank);
    }
}