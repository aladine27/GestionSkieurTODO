package tn.esprit.gestionski.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.*;
import tn.esprit.gestionski.repositories.CoursRepository;
import tn.esprit.gestionski.repositories.InscriptionRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.time.*;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class InscriptionServiceImp implements  IInscription{

  private InscriptionRepository  inscriptionRepository;
  private   SkieurRepository  skieurRepository;
  private CoursRepository CoursRepository;






    @Override
    public Inscription addInscriptionAndAssignToSkieur(Inscription inscription, Long numSkieur) {
        Skieur skieur = skieurRepository.findById(numSkieur).orElse(null);
        inscription.setSkieur(skieur);
        return inscriptionRepository.save(inscription);
    }
    public Inscription addInscriptionAndAssignToCour(Inscription inscription, Long numCours){
        Cours Cour = CoursRepository.findById(numCours).orElse(null);
        inscription.setCours(Cour);
        return inscriptionRepository.save(inscription);
    }

    @Override
    public List<Integer> numInscription(Long numMoniteur, Support support) {
        return null;
    }

    @Override
    public Inscription addInscpriptionAndAssingToCoursAndSkieur(Inscription inscription, long numSkieur, long NumCours) {
        Cours cour = CoursRepository.findById(NumCours).orElse(null);
        Skieur skieur = skieurRepository.getById(numSkieur);

        if (cour.getTypeCours() ==(TypeCours.COLLECTIF_ENFANT) && cour.getInscripion().size() >= 6) {
            throw new IllegalArgumentException(" plus que 6 inscriptions pour cours.");
        } else if (cour.getTypeCours()==(TypeCours.COLLECTIF_ADULTE) && cour.getInscripion().size() >= 6) {
            throw new IllegalArgumentException(" que 6 inscriptions pour ce cours.");
        }
        Date birthDate = skieur.getDateNaissance();
        Instant instant = birthDate.toInstant();
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        LocalDate localDate = zonedDateTime.toLocalDate();

        LocalDate currentDate = LocalDate.now();
        int age = Period.between(localDate, currentDate).getYears();


        if (cour.getTypeCours() ==(TypeCours.COLLECTIF_ADULTE) && age <= 18) {
            throw new IllegalArgumentException("Le skieur doit avoir au moins 18 ans pour s'inscrire à ce cours adulte.");
        }
        inscription.setCours(cour);
        inscription.setSkieur(skieur);

        return inscriptionRepository.save(inscription);
    }




}
