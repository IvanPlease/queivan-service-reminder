package queivan.service.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "_logs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Logs {
    @Id
    @NotNull
    @GeneratedValue
    private UUID id;
    @NotNull
    private String type;
    @NotNull
    private String content;
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Europe/Warsaw")
    private LocalDateTime exceptionDate;
}
