package com.lylechristine.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;

import io.smallrye.mutiny.Multi;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Cacheable
@Table(indexes = {
        @Index(name = "movie_id_index", columnList = "movie_id"),
        @Index(name = "actor_id_index", columnList = "actor_id"),
},
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"movie_id", "actor_id"})
        })
@NamedQueries(value = {@NamedQuery(name = "ActorMovieEntity.getByMovieId",
        query = "SELECT c FROM ActorMovieEntity c JOIN FETCH c.actor where c.movie.id = ?1"),
        @NamedQuery(name = "ActorMovieEntity.getByActorId",
                query = "SELECT c FROM ActorMovieEntity c JOIN FETCH c.movie where c.actor.id = ?1")})
@Getter
public class ActorMovieEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    public Movie movie;

    @OneToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    public Actor actor;


    public static Multi<ActorMovieEntity> getActorsByMovieQuery(Long movieId) {
        return stream("#ActorMovieEntity.getByMovieId", movieId);
    }

    public static Multi<ActorMovieEntity> getMoviesByActorQuery(Long actorId) {
        return stream("#ActorMovieEntity.getByActorId", actorId);
    }

    public String toString() {
        return this.getClass().getSimpleName() + "<" + this.id + ">";
    }

}
