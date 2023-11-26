package tn.esprit.gestionski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.TypeAbonnement;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {



  @Query("select a from Abonnement a where a.typeAbonnement =: type order by a.dateDebut")
    Set<Abonnement> getSubscribtionByType(@Param("type") TypeAbonnement typeAbonnement);

  List<Abonnement>findByDateDebutBetween(Date date1,Date date2);
}
