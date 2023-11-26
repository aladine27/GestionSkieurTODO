package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Moniteur;

public interface Imoniteur {
    public Moniteur addMoniteurAndAssignTo(Moniteur moniteur,long numCours);
}
