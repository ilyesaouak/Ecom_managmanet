package tn.isett.gestioncommande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contenirs")
public class ContenirController {

  @Autowired
  private ContenirService contenirService;

  @GetMapping("/commande/{comid}")
  public List<Contenir> getContenirByCommande(@PathVariable Long comid) {
    return contenirService.getContenirByCommande(comid);
  }

  @PostMapping
  public Contenir addContenir(@RequestBody Contenir contenir) {
    return contenirService.addContenir(contenir);
  }

  @DeleteMapping("/commande/{comid}/article/{artid}")
  public void deleteContenir(@PathVariable Long comid, @PathVariable Long artid) {
    contenirService.deleteContenir(comid, artid);
  }
}
