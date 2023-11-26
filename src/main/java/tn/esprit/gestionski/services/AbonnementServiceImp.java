package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.repositories.AbonnementRepository;

import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class AbonnementServiceImp implements IAbonement {
AbonnementRepository abonnementRepository;
  @Override
  public List<Abonnement> getByDateBetween(Date date1, Date date2) {
    return abonnementRepository.findByDateDebutBetween(date1,date2);
  }

  @Scheduled(fixedRate = 30000)
  public void fixedRightMethode(){
    log.info("methode with fixed rate");
  }

}
