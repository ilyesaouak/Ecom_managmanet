package tn.isett.gestioncommande;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Entity
public class Client {
  @jakarta.persistence.Id
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long clId;
  private String numcl;
  private String nomcl;
  private String prenomcl;
  private String adressecl;
  private String telcl;

  @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Commande> commandes;

  public void setClId(Long clId) {
    this.clId = clId;
  }

  public Long getClId() {
    return clId;
  }

  public String getNumcl() {
    return numcl;
  }

  public void setNumcl(String numcl) {
    this.numcl = numcl;
  }

  public String getNomcl() {
    return nomcl;
  }

  public void setNomcl(String nomcl) {
    this.nomcl = nomcl;
  }

  public String getPrenomcl() {
    return prenomcl;
  }

  public void setPrenomcl(String prenomcl) {
    this.prenomcl = prenomcl;
  }

  public String getAdressecl() {
    return adressecl;
  }

  public void setAdressecl(String adressecl) {
    this.adressecl = adressecl;
  }

  public String getTelcl() {
    return telcl;
  }

  public void setTelcl(String telcl) {
    this.telcl = telcl;
  }

  public Set<Commande> getCommandes() {
    return commandes;
  }

  public void setCommandes(Set<Commande> commandes) {
    this.commandes = commandes;
  }
}

