package university.lab.transport.mapper;

import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import university.lab.transport.config.SpringMapperConfig;
import university.lab.transport.dto.PublicTransportDto;
import university.lab.transport.entity.PublicTransport;
import university.lab.transport.entity.Route;
import university.lab.transport.service.RouteMapperHelperService;

import java.util.Set;

@Setter

@Mapper(config = SpringMapperConfig.class)
public abstract class PublicTransportMapper {

    @Autowired
    private RouteMapperHelperService routeMapperHelperService;

    @Mapping(target = "routeIds", expression = "java(mapRoutes(publicTransport))")
    public abstract PublicTransportDto map(PublicTransport publicTransport);

    @Mapping(target = "routes", expression = "java(mapRouteIdsByDto(publicTransportDto))")
    public abstract PublicTransport map(PublicTransportDto publicTransportDto);

    protected Set<Long> mapRoutes(PublicTransport transport) {
        return routeMapperHelperService.mapRoutes(transport.getRoutes());
    }

    protected Set<Route> mapRouteIdsByDto(PublicTransportDto transportDto) {
        return routeMapperHelperService.mapRouteIds(transportDto.getRouteIds());
    }
}
