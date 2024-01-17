package seminar3.task1;




import java.io.Serializable;

public class UserData implements Serializable {


    public UserData(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    private String name;
    private int age;


  /*  @JsonIgnore
    transient String password;
    */
    transient String password;


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }
}

