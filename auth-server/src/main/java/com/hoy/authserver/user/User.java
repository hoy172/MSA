package com.hoy.authserver.user;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 20, unique = true, nullable = false)
    private String username;

    @Column(length = 400, nullable = false)
    private String password;

    @Column( nullable = false)
    private int userType;

    @Column(nullable = false)
    private LocalDateTime date;


}
