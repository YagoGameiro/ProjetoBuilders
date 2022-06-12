package projeto.dtos;


import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "CLIENTES")
public class Clientes {

    @Id
    @GeneratedValue(generator="CLIENTES_SEQ")
    @SequenceGenerator(name="sequency",sequenceName="CLIENTES_SEQ", allocationSize=1)
    private int id;

    @Column(name="NAME", nullable=false)
    private String name;

    @Column(name="EMAIL")
    private String email;

    @Column(name="BIRTH_DATE", nullable=false)
    private Date birthDate;

    @Column(name="CREATED_DATE", insertable = false)
    private Date createdDate;

    @Transient
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getAge() {
        age = Period.between(getBirthDate().toLocalDate(), LocalDate.now()).getYears();
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
