package pl.fiewicz.model;

import javax.persistence.*;

@Entity
public class Army {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 100000)
    private int knights;
    @Column(length = 100000)
    private int archers;
    @Column(length = 5000)
    private int machines;

    public Army(int knights, int archers, int machines) {
        this.knights = knights;
        this.archers = archers;
        this.machines = machines;
    }

    public Army() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getKnights() {
        return knights;
    }

    public void setKnights(int knights) {
        this.knights = knights;
    }

    public int getArchers() {
        return archers;
    }

    public void setArchers(int archers) {
        this.archers = archers;
    }

    public int getMachines() {
        return machines;
    }

    public void setMachines(int machines) {
        this.machines = machines;
    }
}
