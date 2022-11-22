package models;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class User {

    String login;
    String password;
    String email;

}
