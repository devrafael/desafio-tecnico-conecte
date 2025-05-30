package com.conecte.medsync.models;

import com.conecte.medsync.models.user.UserModel;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="appointment_tb")
public class AppointmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID appointmentId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appointment_datetime_id", referencedColumnName = "appointmentDateTimeId")
    private AppointmentDateTimeModel appointmentDateTime;
    private LocalDateTime requestAt;
    @ManyToOne
    @JoinColumn(name = "patient_user_id")
    private UserModel patient;
    private Boolean appointmentCompleted;
    
    public AppointmentModel(){}

    public AppointmentModel(AppointmentDateTimeModel appointmentDateTime, UserModel patient) {
        this.appointmentDateTime = appointmentDateTime;
        this.requestAt = LocalDateTime.now();
        this.patient = patient;
    }

    public UUID getAppointmentId() {
        return appointmentId;
    }

    public AppointmentDateTimeModel getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public LocalDateTime getRequestAt() {
        return requestAt;
    }

    public UserModel getPatient() {
        return patient;
    }

    public Boolean getAppointmentCompleted() {
        return appointmentCompleted;
    }

    public void setAppointmentDateTime(AppointmentDateTimeModel appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public void setRequestAt(LocalDateTime requestAt) {
        this.requestAt = requestAt;
    }

    public void setPatient(UserModel patient) {
        this.patient = patient;
    }

    public void setAppointmentCompleted(Boolean appointmentCompleted) {
        this.appointmentCompleted = appointmentCompleted;
    }
}
