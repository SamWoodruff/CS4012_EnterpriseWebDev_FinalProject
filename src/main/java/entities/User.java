package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="USERS")
public class User implements  Serializable{

    private int user_id;
    private String logon_id;
    private String password;


    @Id
    @GeneratedValue
    @Column(name="USERS_ID")
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int users_id){this.user_id = users_id;}

    @Column(name="PASSWORD")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password){this.password=password;}

    @Column(name="LOGON_ID")
    public String getLogon_id() {
        return logon_id;
    }
    public void setLogon_id(String logon_id) {
        this.logon_id = logon_id;
    }
    public User(String logon_id, String password) {
        super();
        this.logon_id = logon_id;
        this.password=password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + user_id +
                ", logon_id='" + logon_id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
