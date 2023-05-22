package Entity;

import java.util.Objects;

public class User {
    protected int id;
    protected String fullName, email, password;

    public User() {

    }

    public User(int id) {
        this.id = id;
        fullName = "unknown";
        email = "unknown";
        password = "unknown";
    }

    public User(int id, String fullName, String email, String password) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void printTitle() {
        System.out.printf("%15s%15s%20s%15s", "ID", "FullName", "Email", "Password");
    }

    public void printData() {
        System.out.printf("%15d%15s%20s%15s", id, fullName, email, password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

        @Override
    public String toString() {
        return "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", ";
    }
}
