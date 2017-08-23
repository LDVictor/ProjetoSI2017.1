package com.ufcg.si1.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.service.AdministradorServiceImpl;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdministradorController {

    @Autowired
    private AdministradorServiceImpl adminService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Administrador> logar(@RequestBody Administrador admin) {
        admin = adminService.logar(admin);
        if (admin == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }
}
