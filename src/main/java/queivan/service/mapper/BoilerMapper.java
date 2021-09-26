package queivan.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import queivan.service.domain.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BoilerMapper {
    Boiler mapToBoiler(BoilerCreateDto boilerCreateDto);
    BoilerClientDto mapToBoilerClientDto(Boiler boiler);
    List<BoilerFetchedDto> mapToBoilerFetchedDtoList(List<Boiler> all);
    BoilerFetchedDto mapToBoilerFetchedDto(Boiler returned);
    List<BoilerClosestDto> mapToBoilerClosestDtoList(List<Boiler> closest);
}
