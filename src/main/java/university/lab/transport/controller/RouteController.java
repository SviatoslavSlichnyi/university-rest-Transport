package university.lab.transport.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import university.lab.transport.dto.RouteDto;
import university.lab.transport.service.RouteCrudService;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/route")
public class RouteController {

    private final RouteCrudService routeCrudService;

    // TODO: GET
    @GetMapping("/get/{routeId}")
    public RouteDto fetchRoute(@PathVariable Long routeId) {
//        return routeCrudService.fetchRouteDtoById(routeId);
        return null;
    }

    // TODO: GET_ALL
    @GetMapping("/get/all")
    public List<RouteDto> fetchAllRouteDto() {
//        return routeCrudService.fetchAllRouteDto();
        return null;
    }

    // TODO: POST
    @PostMapping("/save")
    public RouteDto saveRoute(RouteDto routeDto) {
//        return routeCrudService.saveRoteByDto(routeDto);
        return null;
    }

    // TODO: PUT
    @PutMapping("/update")
    public RouteDto updateRoute(RouteDto routeDto) {
//        return routeCrudService.updateRouteByDto(routeDto);
        return null;
    }

    // TODO: DELETE
    @DeleteMapping("/remove/{routeId}")
    public void removeRouteById(@PathVariable Long routeId) {
//        routeCrudService.removeRouteById(routeId);
    }
}
