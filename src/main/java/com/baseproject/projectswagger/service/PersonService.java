package com.baseproject.projectswagger.service;

import com.baseproject.projectswagger.model.PersonDTO;

import java.util.List;

public interface PersonService {

    public List<PersonDTO> getPerson();

    public PersonDTO postPerson(PersonDTO body);

    public PersonDTO putPerson(PersonDTO body);
}
