package com.baseproject.projectswagger.service.impl;

import com.baseproject.projectswagger.model.PessoaDTO;
import com.baseproject.projectswagger.service.PessoaService;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl implements PessoaService {



    @Override
    public PessoaDTO getPessoa() {

        PessoaDTO dto = new PessoaDTO();

        dto.setNome("Bruna");


        return dto;
    }
}
