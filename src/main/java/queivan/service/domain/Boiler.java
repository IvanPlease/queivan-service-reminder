package queivan.service.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "_boilers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Boiler {
    @Id
    @NotNull
    @GeneratedValue
    private UUID id;
    @NotNull
    private String type;
    @NotNull
    private String serialNumber;
    @NotNull
    private Boolean locallyMounted;
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd", timezone="Europe/Warsaw")
    private LocalDate installationDate;
    @JsonFormat(pattern="yyyy-MM-dd", timezone="Europe/Warsaw")
    private LocalDate inspectionDate;
    @NotNull
    @OneToMany(mappedBy = "boiler", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> notes;
    @OneToMany(mappedBy = "boiler", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Picture> pictures;
    @ManyToOne
    private Client client;
}
