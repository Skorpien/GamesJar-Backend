package com.backend.gamesjar.communicator.domain;

import com.backend.gamesjar.domain.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "history")
    private String history = "";

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "Room_id")
    private Room room;

    public History(Long id, String history) {
        this.id = id;
        this.history = history;
    }
}
