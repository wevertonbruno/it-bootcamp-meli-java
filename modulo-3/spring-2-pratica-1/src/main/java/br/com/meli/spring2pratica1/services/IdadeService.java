package br.com.meli.spring2pratica1.services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class IdadeService {

    public Integer getIdadeFromDate(LocalDate date){
        if(date == null) return 0;
        return Period.between(date, LocalDate.now()).getYears();
    }
}
