package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.TypeAbonnement;

import java.util.List;

public interface ISkieur  {
    public Skieur add(Skieur S);

    public Skieur update(Skieur S);

    public List<Skieur> findAll();

    public Skieur findById(long idS);

    public void delete(long idS);
public Skieur AssignSkieurtoPiste(Long numSkieur,Long numPiste);
    public Skieur AddSAndATS(Skieur Skieur,Long numCours);

    public List<Skieur> findSkieurByAbonnement(TypeAbonnement ta);

}

