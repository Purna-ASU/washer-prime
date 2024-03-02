package com.prime.washer.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "First Name is mandatory")
    @Column(name = "first_name")
    @Size(max = 20)
    private String firstName;
    @NotNull(message = "Last Name is mandatory")
    @Column(name = "last_name")
    @Size(max = 20)
    private String lastName;
    @NotNull(message = "Email is mandatory")
    @Column(name = "email_id", unique = true)
    private String emailId;
    @NotNull(message = "Password is mandatory")
    @Column(name = "password")
    private String password;
    @NotNull(message = "Phone Number is mandatory")
    @Column(name = "ph_number")
    private Long phNumber;
    @ManyToOne
    @JoinColumn(name = "time_slot_id")
    private TimeSlots selectedTimeSlot;

    public Users() {
    }

    public Users(String firstName, String lastName, String emailId, String password, Long phNumber) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.password = password;
        this.phNumber = phNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPhNumber() {
        return phNumber;
    }

    public void setPhNumber(Long phNumber) {
        this.phNumber = phNumber;
    }

    public TimeSlots getSelectedTimeSlot() {
        return selectedTimeSlot;
    }

    public void setSelectedTimeSlot(TimeSlots selectedTimeSlot) {
        this.selectedTimeSlot = selectedTimeSlot;
    }

}
