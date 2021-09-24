package queivan.service.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientFetchedDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String address;
    private int phoneNumber;
    private List<BoilerClientDto> boilers;
}
