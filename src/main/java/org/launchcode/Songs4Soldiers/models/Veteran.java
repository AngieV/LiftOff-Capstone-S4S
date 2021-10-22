package org.launchcode.Songs4Soldiers.models;

import javax.persistence.Entity;
import javax.validation.constraints.Size;
import java.util.Date;

//@Entity
public class Veteran extends User{

    private String branch;

    private Date vet_serviceStart;

    private Date vet_serviceEnd;

    @Size(max=500, message = "Description too long!")
    private String vet_help;

    public Veteran(int userId, String username, String email, String phone, String branch, Date vet_serviceStart, Date vet_serviceEnd, String vet_help) {
        super();
        this.branch = branch;
        this.vet_serviceStart = vet_serviceStart;
        this.vet_serviceEnd = vet_serviceEnd;
        this.vet_help = vet_help;
    }

    public Veteran(){}

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Date getVet_serviceStart() {
        return vet_serviceStart;
    }

    public void setVet_serviceStart(Date vet_serviceStart) {
        this.vet_serviceStart = vet_serviceStart;
    }

    public Date getVet_serviceEnd() {
        return vet_serviceEnd;
    }

    public void setVet_serviceEnd(Date vet_serviceEnd) {
        this.vet_serviceEnd = vet_serviceEnd;
    }

    public String getVet_help() {
        return vet_help;
    }

    public void setVet_help(String vet_help) {
        this.vet_help = vet_help;
    }

    @Override
    public String toString() {
        return "Veteran{" +
                "branch='" + branch + '\'' +
                ", vet_serviceStart=" + vet_serviceStart +
                ", vet_serviceEnd=" + vet_serviceEnd +
                ", vet_help='" + vet_help + '\'' +
                '}';
    }
}

