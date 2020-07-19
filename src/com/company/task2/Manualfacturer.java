package com.company.task2;

import java.time.Year;

public class Manualfacturer {

    private String name;
    private Year yearOfEstablisment;
    private String country;

    public Manualfacturer(String name, Year yearOfEstablisment, String country) {
        this.name = name;
        this.yearOfEstablisment = yearOfEstablisment;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Year getYearOfEstablisment() {
        return yearOfEstablisment;
    }

    public void setYearOfEstablisment(Year yearOfEstablisment) {
        this.yearOfEstablisment = yearOfEstablisment;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manualfacturer that = (Manualfacturer) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (yearOfEstablisment != null ? !yearOfEstablisment.equals(that.yearOfEstablisment) : that.yearOfEstablisment != null)
            return false;
        return country != null ? country.equals(that.country) : that.country == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (yearOfEstablisment != null ? yearOfEstablisment.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
}
