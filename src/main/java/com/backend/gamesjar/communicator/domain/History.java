package com.backend.gamesjar.communicator.domain;

import com.backend.gamesjar.domain.Room;
import com.backend.gamesjar.observer.Observable;
import com.backend.gamesjar.observer.Observer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity(name = "history")
public class History implements Observable {

    @Transient
    private List<Observer> observers = new ArrayList<>();

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
    private Room room = new Room();

    public History(Long id, String history) {
        this.id = id;
        this.history = history;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setHistory(String history) {
        this.history = history;
        notifyObservers();
    }
}
