package com.app.backend.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Data
@Component
public class mobile {

String email;
String pass;
@Id
int device_id;
int otp;
Boolean status;
}
