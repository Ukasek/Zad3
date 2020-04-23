package livecoding.example.demo.second;

public class User {
    private String name;
    private String Lastname;
    private int age;

    public User(String name, String lastname, int age) {
        this.name = name;
        Lastname = lastname;
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getLastname() {

        return Lastname;
    }

    public void setLastname(String lastname) {

        Lastname = lastname;
    }

    public int getAge() {

        return Integer.parseInt(String.valueOf(age));
    }

    public void setAge(int age) {

        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + getLastname() + " " + age + " lat";
    }

    public void add(User user) {
        user.add(user);
    }

    public void delete(User user) {
        user.delete(user);
    }
}
