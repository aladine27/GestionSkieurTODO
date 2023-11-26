package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.TypeAbonnement;
import tn.esprit.gestionski.services.IInscription;
import tn.esprit.gestionski.services.ISkieur;
import tn.esprit.gestionski.services.SkieurServiceImp;

import java.util.List;

@RestController
@RequestMapping("/skieur")
@AllArgsConstructor
public class SkieurController  {
    private ISkieur Iski;


    private SkieurServiceImp sk;
    @PostMapping("/add")
    public Skieur addFoyer(@RequestBody Skieur f) {
        return  sk.add(f);
    }
    @PutMapping("/update")
    public Skieur updateFoyer(@RequestBody Skieur f) {
        return  sk.update(f);
    }

    @GetMapping("/getall")
    public List<Skieur> findAllFoyer() {
        return  sk.findAll();
    }
    @GetMapping("/get/{idF}")
    public Skieur findById(@PathVariable long idF) {
        return  sk.findById(idF);
    }
    @DeleteMapping("/delete/{idF}")
    public void deleteFoyer(@PathVariable long idF) {
        sk.delete(idF);
    }


    @PostMapping("AssignSkieurtoPiste/{numSkieur}/{numPiste}")
    private Skieur AssignSkieurtoPiste ( @PathVariable  Long numSkieur,@PathVariable Long numPiste){
        return sk.AssignSkieurtoPiste(numSkieur,numPiste);
    }
    @PostMapping("AssignSkieurtocours/{numCours}")
    public Skieur addSkandAstoCours(Skieur s,long numCours){
        return Iski.AddSAndATS(s,numCours);
    }
    @PostMapping("findSkieurByType")
   public List<Skieur> findByAbonnementType(@PathVariable TypeAbonnement TypeA){
       return Iski.findSkieurByAbonnement(TypeA);

    }

}
