package tn.isett.gestioncommande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

  @Autowired
  private CommandeRepository commandeRepository;

  @GetMapping
  public List<Commande> getAllCommandes() {
    return commandeRepository.findAll();
  }

  @PostMapping
  public Commande createCommande(@RequestBody Commande commande) {
    return commandeRepository.save(commande);
  }

  @PutMapping("/{id}")
  public Commande updateCommande(@PathVariable Long id, @RequestBody Commande commandeDetails) {
    Commande commande = commandeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Commande non trouvée avec l'identifiant : " + id));


    commande.setNumcom(commandeDetails.getNumcom());
    commande.setDatecom(commandeDetails.getDatecom());
    commande.setClId(commandeDetails.getClId());

    return commandeRepository.save(commande);
  }

  @DeleteMapping("/{id}")
  public void deleteCommande(@PathVariable Long id) {
    Commande commande = commandeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Commande non trouvée avec l'identifiant : " + id));

    commandeRepository.delete(commande);
  }
}
