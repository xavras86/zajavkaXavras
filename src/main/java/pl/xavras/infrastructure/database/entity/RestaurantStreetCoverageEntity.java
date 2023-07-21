package pl.xavras.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurant_streetCoverage")
public class RestaurantStreetCoverageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_streetCoverage_id")
    private Integer restaurantStreetCoverageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "streetCoverage_id")
    private StreetCoverageEntity streetCoverage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurant;

}
