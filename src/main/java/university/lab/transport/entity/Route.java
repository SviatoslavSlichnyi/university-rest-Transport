package university.lab.transport.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeId;

    private String name;

    private String RouteNumber;

    private LocalTime interval;

    @ElementCollection
    private Set<LocalTime> schedule;

    @ManyToOne(cascade = CascadeType.ALL)
    private Station startStation;

    @ManyToOne(cascade = CascadeType.ALL)
    private Station endStation;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "route_station_rel",
            joinColumns = @JoinColumn(name = "route_id"),
            inverseJoinColumns = @JoinColumn(name = "station_id")
    )
    private List<Station> stations = new LinkedList<>();

    @ManyToOne
    @JoinColumn(name = "public_transport_id")
    private PublicTransport transport;
}
