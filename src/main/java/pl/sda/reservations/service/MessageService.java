package pl.sda.reservations.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private int counter=0;

    public int getCounter(){
        return counter++;
    }
}
