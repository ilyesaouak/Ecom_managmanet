package tn.isett.gestioncommande;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContenirRepository extends JpaRepository<Contenir, ContenirId> {
    List<Contenir> findByCommandeComId(Long comId);

}

