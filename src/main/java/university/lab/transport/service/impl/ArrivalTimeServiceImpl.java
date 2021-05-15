package university.lab.transport.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import university.lab.transport.dto.*;
import university.lab.transport.entity.type.MeasurementType;
import university.lab.transport.service.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@RequiredArgsConstructor

@Service
public class ArrivalTimeServiceImpl implements ArrivalTimeService {

    private static final Double AVERAGE_PUBLIC_TRANSPORT_SPEED = 45.0;

    private final PublicTransportCrudService transportCrudService;
    private final RouteCrudService routeCrudService;
    private final StationCrudService stationCrudService;
    private final TransportLocationByGpsTrackerService trackerService;

    @Override
    public ArrivalTimeDto calculateTransportArrivalTimeToStationByTransportId(Long stationId, Long transportId) {
        PublicTransportDto transportDto = transportCrudService.fetchTransportDtoById(transportId);
        RouteDto routeDto = routeCrudService.fetchRouteDtoById(transportDto.getRouteId());
        StationDto stationDto = stationCrudService.fetchStationDtoById(stationId);

        TransportLocationDto transportLocationDto = trackerService.getLocationByTransportId(transportId);
        transportDto.setLocation(transportLocationDto);

        Double distance =
                (transportLocationDto.getX() * 2 + transportLocationDto.getY() * 2 + stationDto.getStreetNumber())
                % 1000;
        int expectedArrivalTimeHours = (int) (distance / AVERAGE_PUBLIC_TRANSPORT_SPEED);
        Instant expectedArrivalTime = Instant.now().plus(expectedArrivalTimeHours, ChronoUnit.HOURS);

        return ArrivalTimeDto.builder()
                .transport(transportDto)
                .route(routeDto)
                .selectedStation(stationDto)
                .expectedArrivalTime(expectedArrivalTime.toString())
                .distance(distance)
                .distanceMeasurementType(MeasurementType.KM)
                .build();
    }
}
