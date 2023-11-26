package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.entities.Moniteur;
import tn.esprit.gestionski.repositories.CoursRepository;
import tn.esprit.gestionski.repositories.MoniteurRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class MoniteurServiceImp implements Imoniteur {

CoursRepository CoursRepository;
MoniteurRepository MoniteurRepository;
    @Override
    public Moniteur addMoniteurAndAssignTo(Moniteur moniteur, long numCours) {
        Cours cours =CoursRepository.findById(numCours).orElse(null);
        Set<Cours> coursSet= new HashSet<>();
        coursSet.add(cours);
        moniteur.getCours().add(cours);
        return MoniteurRepository.save(moniteur);

    }

}
