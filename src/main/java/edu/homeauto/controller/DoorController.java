package edu.homeauto.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
public class DoorController {

    // Atributo para guardar as referencias
    private List<DoorDetail> doors = new LinkedList<>();

    @RequestMapping(value="/doors", method = RequestMethod.GET)
    @ResponseBody
    public ListResponse list(){
        // Dados temporários, deverão vir do banco de dados
        ListResponse response = new ListResponse();
        for (DoorDetail detail : doors) {
            response.add(new Link("door", "/door/" + detail.getId()));
        }
        return response;
    }

    @RequestMapping(value="/door/{doorId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<DoorDetail> detail(@PathVariable int doorId){
        Optional<DoorDetail> optDoor = doors.stream().filter(d -> d.getId() == doorId).findAny();
        if (optDoor.isPresent()){
            DoorDetail doorDetail = optDoor.get();
            return new ResponseEntity<>(doorDetail, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/doors", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody DoorDetail doorDetail) throws URISyntaxException {

        int nextId = doors.size() + 1;

        doorDetail.setId(nextId);
        doors.add(doorDetail);

        return ResponseEntity.created(new URI("/door/"+ nextId)).build();
    }

    @RequestMapping(value="/door/{doorId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable int doorId, @RequestBody DoorDetail doorDetail){
        Optional<DoorDetail> optDoor = doors.stream().filter(d -> d.getId() == doorId).findAny();
        if (optDoor.isPresent()){
            doors.set(doorId-1, doorDetail);
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
