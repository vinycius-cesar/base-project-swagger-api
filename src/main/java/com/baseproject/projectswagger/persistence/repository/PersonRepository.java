package com.baseproject.projectswagger.persistence.repository;

import com.baseproject.projectswagger.persistence.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

}
