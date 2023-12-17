package org.example.service;

import org.example.dto.CardDto;
import org.example.dto.ProfileDto;
import org.example.dto.ServiceTypeDTO;
import org.example.repository.ServiceTypeRepository;
import org.example.status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class ServiceTypeService {
    @Autowired
    private  CardService cardService;
    @Autowired
private ServiceTypeRepository serviceTypeRepository;
    @Autowired
    private  ProfileService profileService;

        public void create(ServiceTypeDTO dto) {
            ProfileDto profileDto = profileService.getById(dto.getId());
            CardDto cardDto = cardService.getCardId(dto.getId());
            if (cardDto != null) {
                if (profileDto != null && profileDto.getType().equals(Status.USER)) {
                    if (dto.getBalance() <= cardDto.getBalance()) {
                        cardService.update(dto.getId(), cardDto.setBalance(cardDto.getBalance() - dto.getBalance()));

                        dto.setProfile_Id(dto.getId());
                        dto.setEmployee_id(profileService.getType(Status.EMPLOYEE));

                        dto.setBalance(dto.getBalance());
                        dto.setLocalDate(LocalDate.now());
                        serviceTypeRepository.create(dto);
                    }
                }

            }
        }

        public ServiceTypeService getById(Integer id) {
            return null;
        }

        public List<ServiceTypeDTO> all() {
            return null;
        }

        public List<ServiceTypeDTO> getAllActive() {
            return null;
        }

        public void changeStatus(Integer id, ServiceTypeService status) {
            return;
        }
    }


