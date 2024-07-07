package com.luv2code.springboot.cruddemo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import lombok.*;
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table(name = "address")


public class Address {
    private static final Logger logger = LogManager.getLogger(Address.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "country")
    private String country;

    @Column(name = "government")
    private String government;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @JsonBackReference

    private Teacher myTeacherId;
    // Getters and setters


//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getStreetName() {
//        return streetName;
//    }
//
//    public void setStreetName(String streetName) {
//        this.streetName = streetName;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public String getGovernment() {
//        return government;
//    }
//
//    public void setGovernment(String government) {
//        this.government = government;
//    }
//
//    public Teacher getMyTeacherId() {
//        return myTeacherId;
//    }
//
//    public void setMyTeacherId(Teacher myTeacherId) {
//        this.myTeacherId = myTeacherId;
//    }
//
//    public Address() {}

    public Address(int id, String streetName, String country, String government, Teacher myTeacherId) {
        this.id = id;
        this.streetName = streetName;
        this.country = country;
        this.government = government;
        this.myTeacherId = myTeacherId;
    }

//    @Override
//    public String toString() {
//        return "address{" +
//                "id=" + id +
//                ", streetName='" + streetName + '\'' +
//                ", country='" + country + '\'' +
//                ", government='" + government + '\'' +
//                ", myTeacherId=" + myTeacherId +
//                '}';
//    }
}
