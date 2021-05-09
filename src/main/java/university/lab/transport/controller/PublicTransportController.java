package university.lab.transport.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import university.lab.transport.service.PublicTransportCrudService;

@RequiredArgsConstructor

@RestController
@RequestMapping("/public-transport")
public class PublicTransportController {

     private final PublicTransportCrudService transportCrudService;

}
