package com.example.bomo.model;


import com.example.bomo.role.Region;
import com.example.bomo.role.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RegionalDirector {
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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    @Lob
    private byte[] photo;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String email;
    private String phone;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "regionalDirector", fetch = FetchType.LAZY)
    private List<TerritorialManager> territorialManagers;



    public void setTerritorialManager(TerritorialManager territorialManager) {
        System.out.println("Entering myMethod with param1: " + territorialManager);
        if (territorialManagers == null) {
            territorialManagers = new ArrayList<>();
        }
        territorialManagers.add(territorialManager);
        territorialManager.setRegionalDirector(this);

    }
    public void removeTerritorialManager(TerritorialManager territorialManager) {
        if (territorialManagers != null) {
            territorialManagers.remove(territorialManager);
            territorialManager.setRegionalDirector(null);
        }
    }
    @Override
    public String toString() {
        return "RegionalDirector{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", region=" + region +
                ", birthDate=" + birthDate +
                ", photo=" + Arrays.toString(photo) +
                ", role=" + role +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }


}
