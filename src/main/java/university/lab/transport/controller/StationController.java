package university.lab.transport.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import university.lab.transport.dto.StationDto;
import university.lab.transport.service.StationCrudService;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/station")
public class StationController {

    private final StationCrudService stationCrudService;

    // TODO: GET
    @GetMapping("/get/{stationId}")
    public StationDto getStationById(@PathVariable Long stationId) {
//        return stationCrudService.fetchStationDtoById(stationId);
        return null;
    }

    // TODO: GET_ALL
    @GetMapping("/get/all")
    public List<StationDto> getAllStationDto() {
//        return stationCrudService.fetchAllStationDto();
        return null;
    }

    // TODO: POST
    @PostMapping("/save")
    public StationDto saveStationByDto(StationDto stationDto) {
//        return stationCrudService.saveStationByDto(stationDto);
        return null;
    }

    // TODO: PUT
    @PutMapping("/update")
    public StationDto updateStationByDto(StationDto stationDto) {
//        return stationCrudService.updateStationByDto(stationDto);
        return null;
    }

    // TODO: DELETE
    @DeleteMapping("/remove/{stationId}")
    public void removeStationById(@PathVariable Long stationId) {
//        stationCrudService.removeStationById(stationId);
    }
}
