package tn.isett.gestioncommande;
import java.io.Serializable;
import java.util.Objects;

public class ContenirId implements Serializable {

    private Long comid;
    private Long artid;

    // Constructeurs
    public ContenirId() {
    }

    public ContenirId(Long comid, Long artid) {
        this.comid = comid;
        this.artid = artid;
    }

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

    // hashCode et equals
    @Override
    public int hashCode() {
        return Objects.hash(comid, artid);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContenirId that = (ContenirId) o;
        return Objects.equals(comid, that.comid) &&
                Objects.equals(artid, that.artid);
    }
}

