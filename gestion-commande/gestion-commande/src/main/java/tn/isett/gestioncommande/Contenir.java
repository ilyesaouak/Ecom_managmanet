package tn.isett.gestioncommande;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contenir")
@IdClass(ContenirId.class)
public class Contenir implements Serializable {

  @Id
  private Long comid;

  @Id
  private Long artid;

  private int quantity;

  @ManyToOne
  @JoinColumn(name = "comid", referencedColumnName = "comId", insertable = false, updatable = false)
  private Commande commande;

  @ManyToOne
  @JoinColumn(name = "artid", insertable = false, updatable = false)
  private Article article;

  // Getters et Setters
  public Long getComid() {
    return comid;
  }

  public void setComid(Long comid) {
    this.comid = comid;
  }

  public Long getArtid() {
    return artid;
  }

  public void setArtid(Long artid) {
    this.artid = artid;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Commande getCommande() {
    return commande;
  }

  public void setCommande(Commande commande) {
    this.commande = commande;
  }

  public Article getArticle() {
    return article;
  }

  public void setArticle(Article article) {
    this.article = article;
  }

  // Constructeurs, hashCode, equals, toString
  public Contenir() {
  }

  public Contenir(Long comid, Long artid, int quantity) {
    this.comid = comid;
    this.artid = artid;
    this.quantity = quantity;
  }

  @Override
  public int hashCode() {
    int result = comid != null ? comid.hashCode() : 0;
    result = 31 * result + (artid != null ? artid.hashCode() : 0);
    result = 31 * result + quantity;
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Contenir contenir = (Contenir) o;

    if (quantity != contenir.quantity) return false;
    if (comid != null ? !comid.equals(contenir.comid) : contenir.comid != null) return false;
    return artid != null ? artid.equals(contenir.artid) : contenir.artid == null;
  }

  @Override
  public String toString() {
    return "Contenir{" +
            "comid=" + comid +
            ", artid=" + artid +
            ", quantity=" + quantity +
            '}';
  }
}
