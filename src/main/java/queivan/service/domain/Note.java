package queivan.service.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "_notes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Note {
    @Id
    @NotNull
    @GeneratedValue
    private UUID id;
    @NotNull
    private String content;
    @ManyToOne
    private Boiler boiler;
    @OneToOne
    private Picture picture;
}
