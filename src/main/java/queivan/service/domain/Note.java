package queivan.service.domain;

import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.*;

import java.util.UUID;

@Entity(name = "_notes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Note {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @NotNull
    private String content;
    @ManyToOne
    private Boiler boiler;
    @OneToOne
    private Picture picture;
}
