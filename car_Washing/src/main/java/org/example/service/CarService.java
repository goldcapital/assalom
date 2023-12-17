package org.example.service;

import org.example.dto.CarDto;
import org.example.dto.CardDto;
import org.example.repository.CarRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CarService {
    @Autowired
private CarRepositry carRepositry;

        public void create(CarDto dto) {
            List<CarDto>list=carRepositry.all();
            for (CarDto carDto:list) {
                if (!carDto.getNubar().equals(dto.getNubar())) {

                    dto.setLocalDate(LocalDate.now());
                    carRepositry.create(dto);
                }
            }
            System.out.println("I ALREADY HAVE THIS NUMBER");
        }

        public CardDto findByCarNumber(String carNumber) {
            return carRepositry.findByCarNumber(carNumber);

        }

        public CarDto findById(Integer id) {
            return carRepositry.findById(id);
        }

        public void printAll() {
            List<CarDto>list=carRepositry.all();

        }
    }


