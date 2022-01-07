package com.baseproject.projectswagger.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "PESSOA")
public class PersonEntity implements Serializable {

    @Id
    @SequenceGenerator(name = "pessoa_seq", sequenceName = "pessoa_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_seq")
    @Column(name = "ID_PESSOA")
    private Long idPerson;

    @Column(name = "NOME_PESSOA")
    private String namePerson;

    @Column(name = "IDADE_PESSOA")
    private Long agePerson;

    @Column(name = "CPF_PESSOA")
    private Long cpfPerson;

    @Column(name = "EMAIL_PESSOA")
    private String emailPerson;
}
