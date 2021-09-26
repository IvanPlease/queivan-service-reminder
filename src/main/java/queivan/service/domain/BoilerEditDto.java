package queivan.service.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoilerEditDto {
    private UUID id;
    private String type;
    private String serialNumber;
    private Boolean locallyMounted;
    @JsonFormat(pattern="yyyy-MM-dd", timezone="Europe/Warsaw")
    private LocalDate installationDate;
    @JsonFormat(pattern="yyyy-MM-dd", timezone="Europe/Warsaw")
    private LocalDate inspectionDate;
    private List<NoteBoilerDto> notes;
    private List<PictureClientDto> pictures;
    private ClientId client;
}
