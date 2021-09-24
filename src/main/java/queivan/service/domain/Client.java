package queivan.service.domain;

import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.*;

@Entity(name = "_clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String address;
    @NotNull
    private int phoneNumber;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Boiler> boilers;
}
