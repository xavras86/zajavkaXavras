package pl.xavras.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "streetId")
@ToString(of ={"streetId", "city", "street"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "street")
public class StreetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "street_id")
    private Integer streetId;

    @Column(name = "city")
    private String city;


    @Column(name = "street")
    private String street;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "street")
    private Set<RestaurantStreetEntity> resturantStreet;
}
