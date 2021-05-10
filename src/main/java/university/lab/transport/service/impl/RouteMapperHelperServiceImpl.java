package university.lab.transport.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import university.lab.transport.entity.Route;
import university.lab.transport.repository.RouteRepository;
import university.lab.transport.service.RouteMapperHelperService;

import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor

@Service
public class RouteMapperHelperServiceImpl implements RouteMapperHelperService {

    private final RouteRepository routeRepository;

    public Set<Long> mapRoutes(Set<Route> routes) {
        return routes.stream()
                .map(Route::getRouteId)
                .collect(Collectors.toSet());
    }

    public Set<Route> mapRouteIds(Set<Long> routeIds) {
        return routeIds.stream()
                .map(routeRepository::getOne)
                .collect(Collectors.toSet());
    }
}
