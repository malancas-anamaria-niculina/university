package utcn.tema1.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "petri_id", nullable = false, unique = false)
    private Integer petriId;

    @Column(name = "name", nullable = false, unique = true)
    private String locationName;
    @Column(name = "nr_of_tokens", nullable = false)
    private Integer numberOfTokens;
    @Column(name = "type", nullable = false)
    private Integer type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "petri_id", referencedColumnName = "id")
    private List<Petri> petri;
}
