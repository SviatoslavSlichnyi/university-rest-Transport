package university.lab.transport.entity;

import lombok.*;
import university.lab.transport.entity.type.TransportType;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

@Entity
public class PublicTransport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publicTransportId;

    private TransportType type;

    private String brand;

    private String numberSign;

    private Long transportNumber;

    private Long sitsNumber;

    @OneToMany(mappedBy = "transport")
    private Set<Route> routes;
}
