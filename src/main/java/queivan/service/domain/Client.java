package queivan.service.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "_clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {
    @Id
    @NotNull
    @GeneratedValue
    private UUID id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String address;
    @NotNull
    private int phoneNumber;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Boiler> boilers;
}
