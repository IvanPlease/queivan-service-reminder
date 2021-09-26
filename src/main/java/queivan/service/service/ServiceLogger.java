package queivan.service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import queivan.service.domain.LogsDto;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServiceLogger {
    private final LogsService service;

    public void info(String message) {
        log.info(message);
        service.create(LogsDto.builder()
                .type("info")
                .content(message)
                .exceptionDate(LocalDateTime.now())
                .build());
    }

    public void error(String message) {
        log.error(message);
        service.create(LogsDto.builder()
                .type("error")
                .content(message)
                .exceptionDate(LocalDateTime.now())
                .build());
    }

    public void debug(String message) {
        log.debug(message);
        service.create(LogsDto.builder()
                .type("debug")
                .content(message)
                .exceptionDate(LocalDateTime.now())
                .build());
    }
}
