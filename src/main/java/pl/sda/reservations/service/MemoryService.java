package pl.sda.reservations.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryService {

   private List<Integer> numbers = new ArrayList<>();

   public List<Integer> add(int number){
       numbers.add(number);
       return  numbers;
   }

    public void clear() {
       numbers.clear();
    }
    public int min () {
        int min = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < min) {
                min=numbers.get(i);
            }
        }return min;
    }
    public int max () {
        int max = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > max) {
               max = numbers.get(i);
                System.out.println("");
            }
        }return max;
    }

}
