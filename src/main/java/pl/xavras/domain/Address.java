package pl.xavras.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.With;

@With
@Value
@Builder
@Data
public class Address {
    Integer addressId;
    String country;
    String city;
    String street;
    String buildingNumber;
}
