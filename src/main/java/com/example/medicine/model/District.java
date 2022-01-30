package com.example.medicine.model;

import com.example.medicine.dto.DistrictDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private Clinic clinic;

    public DistrictDTO toDTO(boolean relations){
        DistrictDTO districtDTO = new DistrictDTO();
        districtDTO.setId(this.id);
        districtDTO.setName(this.name);
        if (relations){
            if(this.clinic==null){
                this.toDTO(false);
            }
            else {
                districtDTO.setClinic(this.clinic.toDTO(false));
            }
        }
        return districtDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof District)) return false;
        return id != null && id.equals(((District) o).getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }


}
