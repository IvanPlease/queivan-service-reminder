package queivan.service.domain;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.*;

@Entity(name = "_boilers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Boiler {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @NotNull
    private String boilerType;
    @NotNull
    private String serialNumber;
    @NotNull
    private Boolean locallyMounted;
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Europe/Warsaw")
    private LocalDateTime installationDate;
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Europe/Warsaw")
    private LocalDateTime inspectionDate;
    @NotNull
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> notes;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Picture> pictures;
    @ManyToOne
    private Client client;
}
