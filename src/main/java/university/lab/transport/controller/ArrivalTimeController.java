package university.lab.transport.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import university.lab.transport.dto.ArrivalTimeDto;
import university.lab.transport.service.ArrivalTimeService;

import javax.websocket.server.PathParam;

@RequiredArgsConstructor

@RestController
@RequestMapping("/arrival-time")
public class ArrivalTimeController {

    private final ArrivalTimeService arrivalTimeService;

    @GetMapping("/calculate")
    public ArrivalTimeDto calculateTime(@PathParam("transportId") Long transportId,
                                        @PathParam("stationId") Long stationId) {
        return arrivalTimeService.calculateTransportArrivalTimeToStationByTransportId(stationId, transportId);
    }
}
