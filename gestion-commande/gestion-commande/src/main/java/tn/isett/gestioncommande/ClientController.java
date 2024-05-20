package tn.isett.gestioncommande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

  @Autowired
  private ClientRepository clientRepository;

  @GetMapping
  public List<Client> getAllClients() {
    return clientRepository.findAll();
  }

  @PostMapping
  public Client createClient(@RequestBody Client client) {
    return clientRepository.save(client);
  }

  @PutMapping("/{id}")
  public Client updateClient(@PathVariable Long id, @RequestBody Client clientDetails) {
    Client client = clientRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Client non trouvé avec l'identifiant : " + id));

    client.setNomcl(clientDetails.getNomcl());
    client.setPrenomcl(clientDetails.getPrenomcl());
    client.setAdressecl(clientDetails.getAdressecl());
    client.setTelcl(clientDetails.getTelcl());

    return clientRepository.save(client);
  }

  @DeleteMapping("/{id}")
  public void deleteClient(@PathVariable Long id) {
    Client client = clientRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Client non trouvé avec l'identifiant : " + id));

    clientRepository.delete(client);
  }

}
