package queivan.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import queivan.service.domain.Client;
import queivan.service.domain.ClientCreateDto;
import queivan.service.domain.ClientFetchedDto;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {
    ClientFetchedDto mapToClientFetchedDto(Client client);
    Client mapToClient(ClientCreateDto dto);
    Client mapToClient(ClientFetchedDto dto);
    List<ClientFetchedDto> mapToClientFetchedDtoList(List<Client> all);
}
