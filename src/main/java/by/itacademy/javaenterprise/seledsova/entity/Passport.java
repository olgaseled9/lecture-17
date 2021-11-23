package by.itacademy.javaenterprise.seledsova.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Passports")
public class Passport {

    @Id
    @SequenceGenerator(name = "Passport_passport_id_seq", sequenceName = "Passport_passport_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Passport_passport_id_seq")
    @Column(name = "passport_id")
    private Long passportId;

    private Integer number;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Person person;

    public Passport(Long passportId, Integer number) {
        this.passportId = passportId;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "passportId=" + passportId +
                ", number=" + number +
                '}';
    }
}


