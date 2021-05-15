package university.lab.transport.service;

import university.lab.transport.dto.ArrivalTimeDto;

public interface ArrivalTimeService {
    ArrivalTimeDto calculateTransportArrivalTimeToStationByTransportId(Long stationId, Long transportId);
}
