package br.meli.authentication.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actors")
public class Actor extends AuditEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(precision = 3, scale = 1)
    private Double rating;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "actor")
    private Set<ActorMovie> movies;

    @JsonIgnore
    @OneToMany(mappedBy = "actor",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ActorEpisode> episodes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "favorite_movie_id", referencedColumnName = "id")
    private Movie favoriteMovie;
}
