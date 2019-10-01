package pl.fiewicz.model;

import javax.persistence.*;

@Entity
public class Resources {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 100000)
    private int wood;
    @Column(length = 100000)
    private int gold;
    @Column(length = 100000)
    private int iron;


    public Resources(int wood, int gold, int iron) {
        this.wood = wood;
        this.gold = gold;
        this.iron = iron;
    }

    public Resources() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getWood() {
        return wood;
    }

    public void setWood(int wood) {
        this.wood = wood;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getIron() {
        return iron;
    }

    public void setIron(int iron) {
        this.iron = iron;
    }
}
