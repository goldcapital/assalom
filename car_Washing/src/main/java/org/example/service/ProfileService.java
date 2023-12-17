package org.example.service;

import org.example.status.Status;
import org.example.dto.ProfileDto;
import org.example.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProfileService {

        @Autowired
        private ProfileRepository profileRepository;

        public void create(ProfileDto dto) {
            List<ProfileDto>list=profileRepository.profileList();
            if(dto.getPhone().length()>=13&&dto.getPhone().endsWith("+998")) {
                for (ProfileDto profileDto1 : list) {
                    if(!profileDto1.getPhone().equals(dto.getPhone())) {
                        if(dto.getPaw().equals("2002")){
                            dto.setStatus(Status.AKTEV);
                            dto.setLocalDate(LocalDate.now());
                            dto.setType(Status.EMPLOYEE);
                            profileRepository.create(dto);
                            return;
                        }
                        dto.setStatus(Status.AKTEV);
                        dto.setLocalDate(LocalDate.now());
                        dto.setType(Status.USER);
                        profileRepository.create(dto);
                        return;
                    }

                }
                System.out.println("MAZZGI BU RAQAM BORKU:::::::");
            }

        }

        public void update(Integer id, ProfileDto dto) {
profileRepository.update(id,dto);
        }

        public ProfileDto getById(Integer id) {
            List<ProfileDto>list=profileRepository.profileList();
            for (ProfileDto profileDto1 : list) {
                if (profileDto1 != null&&profileDto1.getId()==id) {
                    return profileDto1;
                }
            }
            return null;

        }
        public void printProfileList() {
            List<ProfileDto>list=profileRepository.profileList();
            for (ProfileDto profileDto1:list){
                System.out.println(profileDto1);
            }

        }

    public ProfileDto login(ProfileDto profileDto) {
        List<ProfileDto>list=profileRepository.profileList();
        for (ProfileDto profileDto1:list){
            if(profileDto1!=null&&profileDto1.getPhone().equals(profileDto.getPhone())&&profileDto1.getPaw().equals(profileDto.getPaw()
            )){
                return profileDto1;
            }
        }
        return null;
    }

    public Integer getType(Status status) {
        List<ProfileDto>list=profileRepository.profileList();
        for (ProfileDto profileDto1:list){
            if(profileDto1!=null&&profileDto1.getType().equals(status)&&profileDto1.ge){
                return profileDto1.getId();
            }
        }
        return o;
    }
}


