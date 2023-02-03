package com.codegym.model.payment;

import com.codegym.model.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Set;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double totalPrice;
    private String orderDate;
    private Integer paymentStatus;
    @Column(columnDefinition = "int default 0")
    private Integer deleteStatus;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @JsonBackReference
    @OneToMany(mappedBy = "payment")
    private Set<OrderAlbum> orderAlbums;

    public Payment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<OrderAlbum> getOrderAlbums() {
        return orderAlbums;
    }

    public void setOrderAlbums(Set<OrderAlbum> orderAlbums) {
        this.orderAlbums = orderAlbums;
    }
}
