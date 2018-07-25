package pl.sda.reservations.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.reservations.model.MessageObject;
import pl.sda.reservations.model.kwadratowe.QuadraticOne;
import pl.sda.reservations.model.kwadratowe.QuadraticTwo;
import pl.sda.reservations.model.kwadratowe.QuadraticZero;
import pl.sda.reservations.service.MessageService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexController {

    @Autowired /*- automatyczne podwiazanie beana*/
    private MessageService messageService;

    @RequestMapping(path= "/index", method = RequestMethod.GET)
    public ResponseEntity index (){
        return ResponseEntity.ok(new MessageObject("Hello!"));
    }

    @RequestMapping(path= "/count", method = RequestMethod.GET)
    public ResponseEntity count(){
        return ResponseEntity.ok(messageService.getCounter());
    }

    @GetMapping (path="/parametrized")
    public ResponseEntity parametrized(@RequestParam(name="who") String who){
        return ResponseEntity.ok(new MessageObject("hello " + who + "!"));
    }
    @GetMapping(path="/fibonacci")
    public ResponseEntity param(@RequestParam(name="quantityOfElements") int quantityOfElements){
        List<Integer> fibonacci = new ArrayList<>();
        for (int i = 0; i <quantityOfElements ; i++) {
            fibonacci.add(calculations(i));
            }return ResponseEntity.ok(fibonacci);
        }

    private int calculations(int which){
        if (which==0)return 0;
        if (which==1)return 1;
        return calculations(which-1)+ calculations(which-2);
    }
    @GetMapping(path = "/kwadratowe")
    public ResponseEntity kwadratowe(@RequestParam(name = "a") int a,
                                     @RequestParam(name = "b") int b,
                                     @RequestParam(name = "c") int c) {

        double delta = b * b - 4 * a * c;
        if (delta > 0) {
            //
            double x1 = (-b - Math.sqrt(delta)) / (2 * a);
            double x2 = (-b + Math.sqrt(delta)) / (2 * a);
//
//            return ResponseEntity.ok(
//                    new MessageObject("x1: " + x1 + " x2: " + x2 + " delta: " + delta));
            return ResponseEntity.ok(new QuadraticTwo(x1, x2, delta));
        } else if (delta == 0) {
            double x0 = (-b) / (2 * a);

//            return ResponseEntity.ok(
//                    new MessageObject("x0: " + x0 + " delta: " + delta));
            return ResponseEntity.ok(new QuadraticOne(x0, delta));
        } else {
            return ResponseEntity.ok(new QuadraticZero(delta));
//            return ResponseEntity.ok(
//                    new MessageObject(" delta: " + delta));
        }
    }

    @GetMapping(path="/liczby")
    public ResponseEntity zakres(@RequestParam (name="poczatekZakresu")int poczatekZakresu,
                                 @RequestParam (name= "koniecZakresu")int koniecZakresu,
                                 @RequestParam (name="dzielnik") int dzielnik){
        List<Integer> numbers = new ArrayList<>();
        for (int i = poczatekZakresu; i <koniecZakresu ; i++) {
            if (i%dzielnik ==0){
               numbers.add(i) ;
            }
        }
     return ResponseEntity.ok(numbers);

    }
    @GetMapping(path="/text")
    public ResponseEntity zakres(@RequestParam (name="text") String text){
        int wynik=0;
        for (int i = 0; i <text.length() ; i++) {
            if(Character.isDigit(text.charAt(i))){
                int cyfraZeZnaku= text.charAt(i)-48;
                wynik+=cyfraZeZnaku;
            }
        }return ResponseEntity.ok(wynik);
    }


}
