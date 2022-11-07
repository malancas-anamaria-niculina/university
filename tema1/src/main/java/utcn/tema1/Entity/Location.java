package utcn.tema1.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
    @Column(name = "entry_transition_id", nullable = true)
    private Integer entryTransitionId;
    @Column(name = "out_transition_id", nullable = true)
    private Integer outputTransitionId;
}
