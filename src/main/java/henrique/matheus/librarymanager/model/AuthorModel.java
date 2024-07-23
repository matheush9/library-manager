package henrique.matheus.librarymanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name="AUTHOR")
public class AuthorModel extends BaseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public String name;
    public int age;
    public String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
