package livecoding.example.demo.second;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> user;

    public UserRepository() {
        user = new ArrayList<>();
        user.add(new User("Ania", "Kania", 25));
        user.add(new User("Kasia", "Basia", 15));
        user.add(new User("Cezary", "Cezary", 20));
    }

    public List<User> getAll() {

        return user;
    }

    public void add(User user) {

        user.add(user);
    }

    public void delete(User user) {

        user.delete(user);
    }
}
