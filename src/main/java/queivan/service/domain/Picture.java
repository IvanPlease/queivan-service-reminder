package queivan.service.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.net.URL;
import java.util.UUID;

@Entity(name = "_pictures")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Picture {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @NotNull
    private URL image;
    @OneToOne
    private Note comment;
    @ManyToOne
    private Boiler boiler;
}
