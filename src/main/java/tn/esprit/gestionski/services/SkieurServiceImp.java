package tn.esprit.gestionski.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.*;
import tn.esprit.gestionski.repositories.CoursRepository;
import tn.esprit.gestionski.repositories.InscriptionRepository;
import tn.esprit.gestionski.repositories.PisteRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.util.List;
import java.util.Set;

@Service
public class SkieurServiceImp implements ISkieur {
    @Autowired
    private SkieurRepository sk;
    @Autowired
    private PisteRepository ps;
    @Autowired
    private CoursRepository cr;

    private InscriptionRepository inscriptionRepository;

    @Override
    public Skieur add(Skieur S) {
        return sk.save(S);
    }

    @Override
    public Skieur update(Skieur S) {
        return sk.save(S);
    }

    @Override
    public List<Skieur> findAll() {
        return sk.findAll();
    }

    @Override
    public Skieur findById(long idS) {
        return sk.findById(idS).orElse(null);
    }

    @Override
    public void delete(long idS) {
        sk.deleteById(idS);
    }

    @Override

    public Skieur AssignSkieurtoPiste(Long numSkieur, Long numPiste) {
            Skieur skieur = sk.findById(numSkieur).orElse(null);
            Piste piste =ps.findById(numPiste).orElse(null);
            skieur.getPistes().add(piste);
            return sk.save(skieur);
        }

    @Override
    public Skieur AddSAndATS(Skieur Skieur, Long numCours) {
        Skieur s = sk.save(Skieur);
        Cours c = cr.findById(numCours).orElse(null);
        Set<Inscription> incrilist = s.getInscripions();
        for (Inscription i : incrilist) {
            i.setSkieur(s);
            i.setCours(c);
            inscriptionRepository.save(i);
        }
        return s;


    }

  @Override
  public List<Skieur> findSkieurByAbonnement(TypeAbonnement ta) {
   return  sk.findByAbonnement_TypeAbonnement(ta);
  }


}


