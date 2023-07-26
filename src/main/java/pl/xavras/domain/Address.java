package pl.xavras.domain;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.With;
import pl.xavras.infrastructure.database.entity.OrderEntity;
import pl.xavras.infrastructure.database.entity.RestaurantEntity;

import java.util.Set;

@With
@Value
@Builder
@Data
public class Address {

    String country;
    String city;
    String street;
    String buildingNumber;
}
