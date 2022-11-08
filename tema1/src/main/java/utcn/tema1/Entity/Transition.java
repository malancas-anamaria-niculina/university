package utcn.tema1.Entity;

import lombok.Data;

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

@Data
@Entity
@Table(name = "transition")
public class Transition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, unique = false)
    private String transitionName;
    @Column(name = "start_time", nullable = true)
    private Integer tempStart;
    @Column(name = "stop_time", nullable = true)
    private Integer tempStop;
    @Column(name = "execution_seconds", nullable = true)
    private Integer secondsOfExecution;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "petri_id", referencedColumnName = "id")
    private List<Petri> petri;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private List<Location> entryLocation;
}
