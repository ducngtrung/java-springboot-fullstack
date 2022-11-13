package Day10_ArrayList.Quan_Ly_Ho_Dan;

public class Person {
    private String name;
    private String birthday;
    private String job;

    // Constructor
    public Person(String name, String birthday, String job) {
        this.name = name;
        this.birthday = birthday;
        this.job = job;
    }

    @Override
    public String toString() {
        return "{" +
            " name: " + name + 
            ", birthday: " + birthday + 
            ", job: " + job + " }";
    }
}