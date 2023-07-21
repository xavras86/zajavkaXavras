package pl.xavras.domain;

import lombok.*;

@With
@Value
@Builder
@Data
public class Restaurant {

    String name;
    String phone;
    String email;

}
