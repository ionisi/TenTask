package mine.SpringApp.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class User {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Name shouldn't be empty")
    @Size(min=2, max=30, message = "Name should be between 2 and 30 characters")
    @Column(name="name")
    private String name;
    @Min(value = 0, message = "Age should be greater than 0")
    @Max(value = 120,message = "Age should be valid")
    @Column(name="age")
    private int age;
    @NotEmpty(message = "Email shouldn't be empty")
    @Email(message = "Email should be valid")
    @Column(name="email")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotEmpty(message = "Name shouldn't be empty") @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "Name shouldn't be empty") @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters") String name) {
        this.name = name;
    }

    @Min(value = 0, message = "Age should be greater than 0")
    @Max(value = 120, message = "Age should be valid")
    public int getAge() {
        return age;
    }

    public void setAge(@Min(value = 0, message = "Age should be greater than 0") @Max(value = 120, message = "Age should be valid") int age) {
        this.age = age;
    }

    public @NotEmpty(message = "Email shouldn't be empty") @Email(message = "Email should be valid") String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty(message = "Email shouldn't be empty") @Email(message = "Email should be valid") String email) {
        this.email = email;
    }
}
