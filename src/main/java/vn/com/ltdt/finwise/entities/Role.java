package vn.com.ltdt.finwise.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
    private String name;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
    private List<AppUser> appUsers = new ArrayList<>();
}
