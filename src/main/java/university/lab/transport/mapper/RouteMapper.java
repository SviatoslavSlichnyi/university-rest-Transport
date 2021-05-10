package university.lab.transport.mapper;

import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import university.lab.transport.config.SpringMapperConfig;
import university.lab.transport.dto.RouteDto;
import university.lab.transport.entity.PublicTransport;
import university.lab.transport.entity.Route;
import university.lab.transport.entity.Station;
import university.lab.transport.repository.PublicTransportRepository;
import university.lab.transport.repository.StationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Setter

@Mapper(config = SpringMapperConfig.class)
public abstract class RouteMapper {

    @Autowired
    private StationRepository stationRepository;
    @Autowired
    private PublicTransportRepository transportRepository;

    @Mapping(target = "startStationId", source = "startStation.stationId")
    @Mapping(target = "endStationId", source = "endStation.stationId")
    @Mapping(target = "stationIds", expression = "java(mapStations(route.getStations()))")
    @Mapping(target = "transportId", source = "transport.publicTransportId")
    public abstract RouteDto map(Route route);

    @Mapping(target = "startStation", expression = "java(fetchStation(routeDto.getStartStationId()))")
    @Mapping(target = "endStation", expression = "java(fetchStation(routeDto.getEndStationId()))")
    @Mapping(target = "stations", expression = "java(mapStationIds(routeDto.getStationIds()))")
    @Mapping(target = "transport", expression = "java(fetchTransport(routeDto.getTransportId()))")
    public abstract Route map(RouteDto routeDto);

    protected List<Long> mapStations(List<Station> stations) {
        return stations.stream()
                .map(Station::getStationId)
                .collect(Collectors.toList());
    }

    protected List<Station> mapStationIds(List<Long> stationIds) {
        return stationIds.stream()
                .map(stationRepository::getOne)
                .collect(Collectors.toList());
    }

    protected Station fetchStation(Long stationId) {
        return stationRepository.getOne(stationId);
    }

    protected PublicTransport fetchTransport(Long transportId) {
        return transportRepository.getOne(transportId);
    }
}
