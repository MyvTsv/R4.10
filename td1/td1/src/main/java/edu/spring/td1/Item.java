package edu.spring.td1;

import java.util.Objects;

public class Item {

    private String nom;
    private int evaluation;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return item.getNom() == this.getNom();
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, evaluation);
    }

}
