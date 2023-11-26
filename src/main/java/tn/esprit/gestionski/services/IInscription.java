package tn.esprit.gestionski.services;

import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Support;

import java.util.List;

public interface IInscription {
    public Inscription addInscriptionAndAssignToSkieur(Inscription inscription, Long numSkieur);
    public Inscription addInscriptionAndAssignToCour(Inscription inscription, Long numCours);
    public List<Integer>numInscription(Long numMoniteur,Support support);
    public Inscription addInscpriptionAndAssingToCoursAndSkieur(Inscription inscription, long numSkieur, long NumCours);


}
