package com.backend.gamesjar.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "password")
    @NotNull
    private String password;

    @ManyToMany
    @JoinTable(
            name = "join_user_room",
            joinColumns = {@JoinColumn(name = "users_id", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "room_id", referencedColumnName = "ID")}
    )
    private List<Room> rooms = new ArrayList<>();

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
