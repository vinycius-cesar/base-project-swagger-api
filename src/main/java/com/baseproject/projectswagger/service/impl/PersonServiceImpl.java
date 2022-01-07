package com.baseproject.projectswagger.service.impl;

import com.baseproject.projectswagger.model.PersonDTO;
import com.baseproject.projectswagger.persistence.entities.PersonEntity;
import com.baseproject.projectswagger.persistence.repository.PersonRepository;
import com.baseproject.projectswagger.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);
    public static final String LOGGER_INFO = "People performed successfully";
    public static final String LOGGER_ERROR = "Could not call the query - PersonServiceImpl";

    @Override
    public List<PersonDTO> getPerson() {

        List<PersonDTO> personDTOList = new ArrayList<>();
        List<PersonEntity> personEntityList = personRepository.findAll();

        try {
            personEntityList.forEach(listDto -> {
                PersonDTO personDTO = new PersonDTO();
                personDTO.setIdPerson(listDto.getIdPerson());
                personDTO.setNamePerson(listDto.getNamePerson());
                personDTO.setAgePerson(listDto.getAgePerson());
                personDTO.setCpfPerson(listDto.getCpfPerson());
                personDTO.setEmailPerson(listDto.getEmailPerson());

                personDTOList.add(personDTO);

                log.info(LOGGER_INFO);
            });
        }catch (Exception e){
            e.printStackTrace();
            log.info(e.getLocalizedMessage());
            log.info(LOGGER_ERROR);
        }

        return personDTOList;
    }

    @Override
    public PersonDTO postPerson(PersonDTO body) {

        try{
            PersonEntity personEntity = new PersonEntity();

            personEntity.setNamePerson(body.getNamePerson());
            personEntity.setAgePerson(body.getAgePerson());
            personEntity.setCpfPerson(body.getCpfPerson());
            personEntity.setEmailPerson(body.getEmailPerson());

            personRepository.save(personEntity);

            log.info(LOGGER_INFO);
        }catch (Exception e){
            e.printStackTrace();
            log.info(e.getLocalizedMessage());
            log.info(LOGGER_ERROR);
        }

        return body;
    }

    @Override
    public PersonDTO putPerson(PersonDTO body) {
        try {

            Optional<PersonEntity> personEntity = personRepository.findById(body.getIdPerson());
            BeanUtils.copyProperties(body, personEntity, "id");

            if(personEntity.isPresent()){
                PersonEntity personDTO = personEntity.get();
                personDTO.setNamePerson(body.getNamePerson());
                personDTO.setAgePerson(body.getAgePerson());
                personDTO.setCpfPerson(body.getCpfPerson());
                personDTO.setEmailPerson(body.getEmailPerson());

                personRepository.save(personDTO);
            }

        }catch (Exception e){
            e.printStackTrace();
            log.info(e.getLocalizedMessage());
            log.info(LOGGER_ERROR);
        }
        return body;
    }
}
