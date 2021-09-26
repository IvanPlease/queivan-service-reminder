package queivan.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import queivan.service.domain.ClientCreateDto;
import queivan.service.domain.ClientFetchedDto;
import queivan.service.domain.Logs;
import queivan.service.domain.LogsDto;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogsMapper {
    List<LogsDto> mapToLogsDtoList(List<Logs> all);
    Logs mapToLogs(LogsDto dto);
    LogsDto mapToLogsDto(Logs fetched);
}
