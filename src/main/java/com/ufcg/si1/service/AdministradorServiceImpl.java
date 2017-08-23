package com.ufcg.si1.service;

import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.repositorios.AdministradorRepositorio;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service("AdministradorServiceImpl")
public class AdministradorServiceImpl {
    @Autowired
    private AdministradorRepositorio adminRepositorio;

    public Administrador logar(Administrador admin) {
        return logar(admin.getLogin(), admin.getSenha());
    }

    public Administrador logar(String login, String senha) {
        List<Administrador> admins = adminRepositorio.findAll();
        for (Administrador admin : admins) {
            if (admin.getLogin().equals(login)) {
                if(admin.getSenha().equals(senha)) {
                    return admin;
                }
            }
        }
        return null;
    }
}
