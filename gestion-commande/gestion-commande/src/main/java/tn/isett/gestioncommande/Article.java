package tn.isett.gestioncommande;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Article {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long artId;
  private String codeart;
  private String desart;
  private String couleur;
  private Double puart;
  private Integer qtestock;

  @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonIgnore
  private Set<Contenir> contenirSet;


  public Long getArtId() {
    return artId;
  }

  public void setArtId(Long artId) {
    this.artId = artId;
  }

  public String getCodeart() {
    return codeart;
  }

  public void setCodeart(String codeart) {
    this.codeart = codeart;
  }

  public String getDesart() {
    return desart;
  }

  public void setDesart(String desart) {
    this.desart = desart;
  }

  public String getCouleur() {
    return couleur;
  }

  public void setCouleur(String couleur) {
    this.couleur = couleur;
  }

  public Double getPuart() {
    return puart;
  }

  public void setPuart(Double puart) {
    this.puart = puart;
  }

  public Integer getQtestock() {
    return qtestock;
  }

  public void setQtestock(Integer qtestock) {
    this.qtestock = qtestock;
  }

  public Set<Contenir> getContenirSet() {
    return contenirSet;
  }

  public void setContenirSet(Set<Contenir> contenirSet) {
    this.contenirSet = contenirSet;
  }
}
