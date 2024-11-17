package TDB.ExamenParcial.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="alumno")
public class AlumnoModel {
    @Id
    @Column(name="id_alumno")
    public Integer idAlumno;

    @Column(name= "nombre")
    public String nombre;

    @Column(name= "nota")
    public double nota;

}
