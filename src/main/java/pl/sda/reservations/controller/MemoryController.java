package pl.sda.reservations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.reservations.service.MemoryService;

@RestController /*powoduje ze Mappingi mozemy tworzyc*/
public class MemoryController {

    @Autowired
    private MemoryService memoryService;

    @GetMapping(path="/dodaj")
    private ResponseEntity add (@RequestParam (name="number")int number){
        return ResponseEntity.ok(memoryService.add(number));
    }
    @GetMapping(path="/usun")
    private ResponseEntity remove (){
        memoryService.clear();
        return ResponseEntity.ok().build();
    }
    @GetMapping(path="/min")
    private ResponseEntity min (){
    return ResponseEntity.ok(memoryService.min());
    }
    @GetMapping(path="/max")
    private ResponseEntity max (){
        return ResponseEntity.ok(memoryService.max());
    }
}
