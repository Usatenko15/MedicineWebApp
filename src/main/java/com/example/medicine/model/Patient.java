package com.example.medicine.model;

import com.example.medicine.dto.PatientDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String dateBirth;

    @JsonIgnore
    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private Set<Appointment> appointments = new HashSet<>();
    @ManyToOne(cascade = CascadeType.ALL)
    private Clinic clinic;

    public PatientDTO toDTO(boolean relations){
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(this.id);
        patientDTO.setName(this.name);
        patientDTO.setDateBirth(this.dateBirth);
        if (relations) {
            if (this.clinic == null){
                return this.toDTO(false);
            }
            patientDTO.setClinic(this.clinic.toDTO(false));
        }
        return patientDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Patient)) return false;
        return id != null && id.equals(((Patient) o).getId());
    }
    @Override
    public int hashCode() {
        return 31;
    }
}
