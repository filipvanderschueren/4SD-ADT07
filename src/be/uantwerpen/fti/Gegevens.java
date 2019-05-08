package be.uantwerpen.fti;

public class Gegevens {
    private Integer leeftijd;
    private Integer loon;

    public Gegevens(Integer leeftijd, Integer loon) {
        this.leeftijd = leeftijd;
        this.loon = loon;
    }

    public Integer getLeeftijd() {
        return leeftijd;
    }

    public Integer getLoon() {
        return loon;
    }

    public void setLeeftijd(Integer leeftijd) {
        this.leeftijd = leeftijd;
    }

    public void setLoon(Integer loon) {
        this.loon = loon;
    }


}

