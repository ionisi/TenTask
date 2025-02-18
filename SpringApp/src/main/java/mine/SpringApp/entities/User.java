package mine.SpringApp.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
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
}
