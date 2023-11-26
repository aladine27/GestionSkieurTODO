package tn.esprit.gestionski.controllers;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.services.AbonnementServiceImp;

import java.util.Date;
import java.util.List;

@RestController
public class AbonnementControlleur {
  AbonnementServiceImp abonnementServiceImp;

  List<Abonnement> findbetween (@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date1, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date2){
 return  abonnementServiceImp.getByDateBetween(date1,date2);
  }


}
