package com.baseproject.projectswagger.controller.impl;


import com.baseproject.projectswagger.controller.PessoaApi;
import com.baseproject.projectswagger.model.PessoaDTO;
import com.baseproject.projectswagger.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController implements PessoaApi {

    @Autowired
    private PessoaService service;

    @Override
    public ResponseEntity<PessoaDTO> getPessoa() {
        return ResponseEntity.ok(service.getPessoa());
    }
}
