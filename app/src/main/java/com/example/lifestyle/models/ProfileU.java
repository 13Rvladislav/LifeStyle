package com.example.lifestyle.models;

public class ProfileU {
    String Name;
    int Mmr;
    int algorithm, security, pc, programming, informatic;

    public ProfileU() {
        this.Name = Name;
        this.Mmr = 0;
        this.algorithm = 0;
        this.security = 0;
        this.pc = 0;
        this.programming = 0;
        this.informatic = 0;
    }

    public ProfileU(String name, int mmr, int algorithm, int security, int pc, int programming, int informatic) {
        this.Name = name;
        this.Mmr = mmr;
        this.algorithm = algorithm;
        this.security = security;
        this.pc = pc;
        this.programming = programming;
        this.informatic = informatic;
    }

    //геттер и сеттер
    public String getName() {return this.Name;}
    public void setName(String name) {
        this.Name = name;
    }

    public int getMmr() {
        return this.Mmr;
    }
    public void setMmr(int mmr) {
        this.Mmr = mmr;
    }

    public int getAlgorithm() {return this.algorithm;}
    public void setAlgorithm(int algorithm) {this.algorithm = algorithm;}

    public int getSecurity() {return this.security;}
    public void setSecurity(int security) {this.security = security;}

    public int getPc() {return this.pc;}
    public void setPc(int pc) {this.pc = pc;}

    public int getProgramming() {return this.programming;}
    public void setProgramming(int programming) {this.programming = programming;}

    public int getInformatic() {return this.informatic;}
    public void setInformatic(int informatic) {this.informatic = informatic;}

    @Override
    public String toString() {
        return "ProfileU{" +
                "Name='" + Name + '\'' +
                ", Mmr=" + Mmr +
                '}';
    }
}
