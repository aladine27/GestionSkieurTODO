package tn.esprit.gestionski.controllers;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.Support;
import tn.esprit.gestionski.services.IInscription;
import tn.esprit.gestionski.services.InscriptionServiceImp;
import tn.esprit.gestionski.services.SkieurServiceImp;

import java.util.List;

@RestController
@AllArgsConstructor
public class InscriptionController {
    private InscriptionServiceImp  ImInscription;
    @PostMapping("addInscriptionAndAssignToSkieur/{numSk}")
    private Inscription addInscriptionAndAssignToSkieur (@RequestBody Inscription i,@PathVariable Long numSk){
        return ImInscription.addInscriptionAndAssignToSkieur(i,numSk);
    }
    @PostMapping("addInscriptionAndAssignTocours/{numCours}")
    private Inscription addInscriptionAndAssignToCours (@RequestBody Inscription i,@PathVariable Long numCours){

        return ImInscription.addInscriptionAndAssignToCour(i,numCours);
    }
    @GetMapping("/numInscription/")
  public List<Integer> numInscription(@PathVariable Long numMont, @PathVariable Support support) {
    return ImInscription.numInscription(numMont,support);
  }

  @PostMapping("/addInscpriptionAndAssingToCoursAndSkieur/{numSkieur}/{numCours}")
  public Inscription addInscpriptionAndAssingToCoursAndSkieur(@RequestBody Inscription inscription, @PathVariable long numSkieur, @PathVariable long NumCours){
    return ImInscription.addInscpriptionAndAssingToCoursAndSkieur(inscription, numSkieur, NumCours);
  }



}
