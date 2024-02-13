package com.avanish.firstJobApplication.Review;

import com.avanish.firstJobApplication.company.CompanyEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private int rating;

    public ReviewEntity(Long id, String description, int rating) {
        this.id = id;
        this.description = description;
        this.rating = rating;
    }

    public ReviewEntity() {

    }
    @JsonIgnore
    @ManyToOne
    private CompanyEntity company;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
