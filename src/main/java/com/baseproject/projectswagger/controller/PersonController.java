package com.baseproject.projectswagger.controller;


import com.baseproject.projectswagger.model.PersonDTO;
import com.baseproject.projectswagger.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController implements PessoaApi {

    @Autowired
    private PersonService personService;

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);


    @Override
    public ResponseEntity<List<PersonDTO>> getPessoa() {

        try {
            return ResponseEntity.ok(personService.getPerson());

        }catch(Exception e){
            e.printStackTrace();
            log.info(e.getLocalizedMessage());
            logger.error("Error controller GET - PersonController.class");
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<PersonDTO> postPessoa(PersonDTO body) {
        try{
            return ResponseEntity.ok(personService.postPerson(body));

        }catch (Exception e){
            e.printStackTrace();
            log.info(e.getLocalizedMessage());
            logger.error("Error controller POST - PersonController.class");
            return ResponseEntity.badRequest().build();
        }

    }

    @Override
    public ResponseEntity<PersonDTO> putPessoa(PersonDTO body) {
        try{
            return ResponseEntity.ok(personService.putPerson(body));

        }catch(Exception e){
            e.printStackTrace();
            log.info(e.getLocalizedMessage());
            logger.error("Error controller POST - PersonController.class");
            return ResponseEntity.badRequest().build();
        }
    }
}
