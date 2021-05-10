package university.lab.transport.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import university.lab.transport.dto.PublicTransportDto;
import university.lab.transport.service.PublicTransportCrudService;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/public-transport")
public class PublicTransportController {

     private final PublicTransportCrudService transportCrudService;

     // TODO: GET
     @GetMapping("/get/{transportId}")
     public PublicTransportDto fetchTransportById(@PathVariable Long transportId) {
//          return transportCrudService.fetchTransportDtoById(transportId);
          return null;
     }

     // TODO: GET_ALL
     @GetMapping("/get/all")
     public List<PublicTransportDto> fetchAllTransport() {
//          return transportCrudService.fetchAllPublicTransportDtos();
          return null;
     }

     // TODO: POST
     @PostMapping("/save")
     public PublicTransportDto saveTransport(PublicTransportDto transportDto) {
//          return transportCrudService.saveTransportByDto(transportDto);
          return null;
     }

     // TODO: PUT
     @PutMapping("/update")
     public PublicTransportDto updateTransport(PublicTransportDto transportDto) {
//          return transportCrudService.updateTransportByDto(transportDto);
          return null;
     }

     // TODO: DELETE
     @DeleteMapping("/remove/{transportId}")
     public void removeTransport(@PathVariable Long transportId) {
//          transportCrudService.removeById(transportId);
     }
}
