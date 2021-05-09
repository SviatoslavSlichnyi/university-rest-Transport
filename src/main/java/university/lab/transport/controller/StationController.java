package university.lab.transport.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import university.lab.transport.service.StationCrudService;

@RequiredArgsConstructor

@RestController
@RequestMapping("/station")
public class StationController {

    private final StationCrudService stationCrudService;

}
