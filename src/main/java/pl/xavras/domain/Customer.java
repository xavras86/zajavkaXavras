package pl.xavras.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.With;

@With
@Value
@Builder
@Data
public class Customer {

    Integer customerId;
    String name;
    String surname;
    String login;
    String phone;
    String email;

}
