package tn.isett.gestioncommande;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class Commande {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long comId;
  private String numcom;
  private Date datecom;

  @Column(name = "clId")
  private Long clId;
  @ManyToOne
  @JoinColumn(name = "clId", insertable = false, updatable = false)
  private Client client;

  @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonIgnore
  private Set<Contenir> contenirSet;

  public Long getComId() {
    return comId;
  }

  public void setComId(Long comId) {
    this.comId = comId;
  }

  public String getNumcom() {
    return numcom;
  }

  public void setNumcom(String numcom) {
    this.numcom = numcom;
  }

  public Date getDatecom() {
    return datecom;
  }

  public void setDatecom(Date datecom) {
    this.datecom = datecom;
  }

  public Long getClId() {
    return clId;
  }

  public void setClId(Long clId) {
    this.clId = clId;
  }
}


