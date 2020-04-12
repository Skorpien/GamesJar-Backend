package com.backend.gamesjar.communicator.mapper;

import com.backend.gamesjar.communicator.domain.History;
import com.backend.gamesjar.communicator.domain.HistoryDto;
import com.backend.gamesjar.domain.Game;
import com.backend.gamesjar.domain.GameDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HistoryMapper {

    public History mapToHistory(final HistoryDto historyDto) {
        return new History(
                historyDto.getId(),
                historyDto.getHistory()
        );
    }

    public HistoryDto mapToHistoryDto(final History history) {
        return new HistoryDto(
                history.getId(),
                history.getHistory()
        );
    }

    public List<HistoryDto> mapToHistoryDtoList(final List<History> histories) {
        return histories.stream()
                .map(history -> new HistoryDto(history.getId(), history.getHistory()))
                .collect(Collectors.toList());
    }
}
