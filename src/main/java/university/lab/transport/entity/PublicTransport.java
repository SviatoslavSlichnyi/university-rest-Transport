package university.lab.transport.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

@Entity
public class PublicTransport {

    @Id
    private Long publicTransportId;

    private String type;

    private String brand;

    private String numberSign;

    private Long transportNumber;

    private Long sitsNumber;

    @OneToMany(mappedBy = "transport")
    private Set<Route> routes;
}
