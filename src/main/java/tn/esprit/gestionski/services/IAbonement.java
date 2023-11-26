package tn.esprit.gestionski.services;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestionski.entities.Abonnement;

import java.util.Date;
import java.util.List;

public interface IAbonement  {

public List<Abonnement>getByDateBetween (Date date1,Date date2);
}
