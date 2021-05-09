package university.lab.transport.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import university.lab.transport.service.RouteCrudService;

@RequiredArgsConstructor

@RestController
@RequestMapping("/route")
public class RouteController {

    private final RouteCrudService routeCrudService;

}
