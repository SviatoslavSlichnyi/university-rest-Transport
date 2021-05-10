package university.lab.transport.dto;

import lombok.*;
import university.lab.transport.entity.type.TransportType;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class PublicTransportDto {

    private Long publicTransportId;

    private TransportType type;

    private String brand;

    private String numberSign;

    private Long transportNumber;

    private Long sitsNumber;

    private Set<Long> routeIds;
}
