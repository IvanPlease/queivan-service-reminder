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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LogsDto {
    private UUID id;
    private String type;
    private String content;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Europe/Warsaw")
    private LocalDateTime exceptionDate;
}
