package com.example.bomo.model;


import com.example.bomo.role.Region;
import com.example.bomo.role.Role;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.ArrayList;
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
    @Getter
    @Setter
    private List<TerritorialManager> territorialManagers;



    public void setTerritorialManager(TerritorialManager territorialManager) {
        System.out.println("Entering myMethod with param1: " + territorialManager);
        if (territorialManagers == null) {
            territorialManagers = new ArrayList<>();
        }
        territorialManagers.add(territorialManager);
        territorialManager.setRegionalDirector(this);
        System.out.println();
    }
    public void removeTerritorialManager(TerritorialManager territorialManager) {
        if (territorialManagers != null) {
            territorialManagers.remove(territorialManager);
            territorialManager.setRegionalDirector(null);
        }
    }



}
