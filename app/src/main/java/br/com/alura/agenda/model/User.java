package br.com.alura.agenda.model;

/**
 * Created by lucas on 16/04/2017.
 */

public class User {

    private Long id;
    private String name;
    private String address;
    private String phone;
    private String site;
    private Double rating;

    public User(String name, String address, String phone, String site, Double rating) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.site = site;
        this.rating = rating;
    }

    public User(long id, String name, String address, String phone, String site, double rating) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.site = site;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
