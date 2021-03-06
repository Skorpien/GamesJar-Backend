package com.backend.gamesjar.communicator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HistoryDto {
    private Long id;
    private String history;
}
