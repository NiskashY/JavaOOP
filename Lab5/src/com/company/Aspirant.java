package com.company;

public class Aspirant extends Student {
    String scientific_research;

    public String getScientific_research() {
        return scientific_research;
    }

    public void setScientific_research(String scientific_research) {
        this.scientific_research = scientific_research;
    }

    public Aspirant(String firstNAme, String lastName, String group,
                    double averageMark, String scientific_research) {

        super(firstNAme, lastName, group, averageMark);
        this.scientific_research = scientific_research;
    }

    public Aspirant() {}

    @Override
    public int getScholarship() {
        return averageMark == 10 ? 200 : 180;
    }
}
