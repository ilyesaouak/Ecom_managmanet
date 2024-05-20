package tn.isett.gestioncommande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContenirService {

    @Autowired
    private ContenirRepository contenirRepository;

    public List<Contenir> getContenirByCommande(Long comid) {
        return contenirRepository.findByCommandeComId(comid);
    }

    public Contenir addContenir(Contenir contenir) {
        return contenirRepository.save(contenir);
    }

    public void deleteContenir(Long comid, Long artid) {
        contenirRepository.deleteById(new ContenirId(comid, artid));
    }

    public Contenir updateContenir(Contenir contenir) {
        return contenirRepository.save(contenir);
    }
}

