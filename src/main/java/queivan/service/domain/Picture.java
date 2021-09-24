package queivan.service.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @GeneratedValue
    private UUID id;
    @NotNull
    private URL image;
    @OneToOne
    private Note comment;
    @ManyToOne
    private Boiler boiler;
}
