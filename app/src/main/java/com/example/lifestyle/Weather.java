package com.example.lifestyle;

import java.lang.reflect.Array;

public class Weather {
    private Object coord;
    private Object weather;
    private String base;
    private Object main;
    private Number visibility;
    private Object wind;
    private Object clouds;
    private Number dt;
    private Object sys;
    private Number timezone;
    private Number id;
    private String name;
    private Number cod;

    public Weather(Object coord, Object weather, String base, Object main, Number visibility, Object wind, Object clouds, Number dt, Object sys, Number timezone, Number id, String name, Number cod) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.timezone = timezone;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public Object getCoord() {
        return coord;
    }

    public void setCoord(Object coord) {
        this.coord = coord;
    }

    public Object getWeather() {
        return weather;
    }

    public void setWeather(Object weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Object getMain() {
        return main;
    }

    public void setMain(Object main) {
        this.main = main;
    }

    public Number getVisibility() {
        return visibility;
    }

    public void setVisibility(Number visibility) {
        this.visibility = visibility;
    }

    public Object getWind() {
        return wind;
    }

    public void setWind(Object wind) {
        this.wind = wind;
    }

    public Object getClouds() {
        return clouds;
    }

    public void setClouds(Object clouds) {
        this.clouds = clouds;
    }

    public Number getDt() {
        return dt;
    }

    public void setDt(Number dt) {
        this.dt = dt;
    }

    public Object getSys() {
        return sys;
    }

    public void setSys(Object sys) {
        this.sys = sys;
    }

    public Number getTimezone() {
        return timezone;
    }

    public void setTimezone(Number timezone) {
        this.timezone = timezone;
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getCod() {
        return cod;
    }

    public void setCod(Number cod) {
        this.cod = cod;
    }
}
