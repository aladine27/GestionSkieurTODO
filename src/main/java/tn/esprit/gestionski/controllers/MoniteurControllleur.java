package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.entities.Moniteur;
import tn.esprit.gestionski.services.Imoniteur;
import tn.esprit.gestionski.services.MoniteurServiceImp;


@RestController
@AllArgsConstructor

public class MoniteurControllleur {
    @Autowired
    Imoniteur imoniteur;
    MoniteurServiceImp  MoniteurServiceImp;

    @PostMapping("/addMoniteurTocours/{numCours}")
    public  Moniteur addMoniteurAndAssignToCours(@RequestBody  Moniteur moniteur,@PathVariable Long numCours){
        return imoniteur.addMoniteurAndAssignTo(moniteur,numCours);

    }
}
