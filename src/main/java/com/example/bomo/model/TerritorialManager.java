package com.example.bomo.model;



import com.example.bomo.role.Region;
import com.example.bomo.role.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TerritorialManager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String middleName;

    @Enumerated(EnumType.STRING)
    private Region region;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    @Lob
    private byte[] photo;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String email;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "regional_director_id")
    private RegionalDirector regionalDirector;


}
