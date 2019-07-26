package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "person")
@Table(name = "person")
public class Person implements Serializable {
    public Person(String name, String family,String sex) {
        this.name = name;
        this.family = family;
        this.sex=sex;
    }

    public Person() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "NUMBER")
    private long id;
    @Column(columnDefinition = "VARCHAR2(20)")
    private String name;
    @Column(columnDefinition = "VARCHAR2(20)")
    private String family;
    @Column(columnDefinition = "CHAR(1)")
    private String sex="0";

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
