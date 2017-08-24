package com.ufcg.si1.service;

import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.repositorios.AdministradorRepositorio;

import com.ufcg.si1.service.interfaces.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AdministradorServiceImpl")
public class AdministradorServiceImpl implements AdministradorService {
    @Autowired
    private AdministradorRepositorio adminRepositorio;

    @Override
    public Administrador logar(Administrador admin) {
        return logar(admin.getLogin(), admin.getSenha());
    }

    private Administrador logar(String login, String senha) {
        List<Administrador> admins = adminRepositorio.findAll();
        for (Administrador admin : admins) {
            if (admin.getLogin().equalsIgnoreCase(login)) {
                if(admin.getSenha().equals(senha)) {
                    return admin;
                }
            }
        }
        return null;
    }
}
