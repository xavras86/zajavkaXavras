package pl.xavras.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "streetCoverage")
public class StreetCoverageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "streetCoverage_id")
    private Integer StreetCoverageId;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "streetCoverage")
    private Set<RestaurantStreetCoverageEntity> resturantStreetCoverage;
}
