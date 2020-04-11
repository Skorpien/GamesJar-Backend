package com.backend.gamesjar.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GameDto {
    private Long id;
    private String name;
    private PlayingTime time;
    private Category categories;
}
