package ccs.education.login.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "account")
@Entity
public class Account {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="password")

    private String password;

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
}