package com.luv2code.springboot.cruddemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.HashSet;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Entity
@NoArgsConstructor
@ToString
@Table(name = "teachers")
public class Teachers {
    private static final Logger logger = LogManager.getLogger(Teachers.class);

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;
    @OneToMany(mappedBy = "myTeacherId", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore

    private Set<Address> address = new HashSet<>();

    // define constructors
//public Teachers() {}

    public Teachers(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

    }


    // define getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Address> getAddresses() {
        return address;
    }

    public void setAddresses(Set<Address> addresses) {
        this.address = addresses;
        for (Address address : addresses) {
            address.setMyTeacherId(this);
        }
    }

    //adding or removing from  table address
    public void addAddress(Address address) {
        if (this.address == null) {
            this.address = new HashSet<>();
        }
        this.address.add(address);
        address.setMyTeacherId(this);
    }

    public void removeAddress(Address address) {
        this.address.remove(address);
        address.setMyTeacherId(null);
    }
// define toString


//    @Override
//    public String toString() {
//        return "Teachers{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", age=" + age +
//                ", address=" + address +
//                '}';
//    }

}








