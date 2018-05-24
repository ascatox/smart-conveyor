package it.eng.smartconveyor.model;

import java.util.List;

public class Bay {

    private String id;
    private Slot slot;
    private List<Preference> preferences;
    private int loadFactor;
    private int loadFactorPotential;

    public Bay() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public List<Preference> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Preference> preferences) {
        this.preferences = preferences;
    }

    public int getLoadFactor() {
        return loadFactor;
    }

    public void setLoadFactor(int loadFactor) {
        this.loadFactor = loadFactor;
    }

    public int getLoadFactorPotential() {
        return loadFactorPotential;
    }

    public void setLoadFactorPotential(int loadFactorPotential) {
        this.loadFactorPotential = loadFactorPotential;
    }
}
