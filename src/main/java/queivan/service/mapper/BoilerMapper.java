package queivan.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import queivan.service.domain.Boiler;
import queivan.service.domain.BoilerClientDto;
import queivan.service.domain.BoilerCreateDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BoilerMapper {
    Boiler mapToBoiler(BoilerCreateDto boilerCreateDto);
    BoilerCreateDto mapToBoilerCreateDto(Boiler boiler);
    BoilerClientDto mapToBoilerClientDto(Boiler boiler);
}
