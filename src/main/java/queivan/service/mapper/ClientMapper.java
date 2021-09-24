package queivan.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import queivan.service.domain.Client;
import queivan.service.domain.ClientFetchedDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {
    ClientFetchedDto mapToClientFetchedDto(Client client);
    Client mapToClient(ClientFetchedDto dto);
}
