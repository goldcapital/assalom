package org.example.service;

import org.example.dto.CardDto;
import org.example.repository.CardRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CardService {
    @Autowired
    private CardRepositry cardRepositry;
    public CardDto getCardId(Integer id) {
        List<CardDto> list=cardRepositry.all();
        for (CardDto cardDto:list){
            if(cardDto!=null&&cardDto.getId()==id){
                return cardDto;
            }
        }
        return null;
    }

}
