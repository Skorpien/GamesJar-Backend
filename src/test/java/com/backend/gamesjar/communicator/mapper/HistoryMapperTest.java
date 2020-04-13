package com.backend.gamesjar.communicator.mapper;

import com.backend.gamesjar.communicator.domain.History;
import com.backend.gamesjar.communicator.domain.HistoryDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class HistoryMapperTest {

    @InjectMocks
    private HistoryMapper historyMapper;

    @Test
    public void mapToHistory() {

        //Given
        HistoryDto historyDto = new HistoryDto(1L, "history");

        //When
        History history = historyMapper.mapToHistory(historyDto);

        //Then
        Assert.assertEquals(historyDto.getId(), history.getId());
        Assert.assertEquals(historyDto.getHistory(), history.getHistory());
    }

    @Test
    public void mapToHistoryDto() {

        //Given
        History history = new History(1L, "history");

        //When
        HistoryDto historyDto = historyMapper.mapToHistoryDto(history);

        //Then
        Assert.assertEquals(history.getId(), historyDto.getId());
        Assert.assertEquals(history.getHistory(), historyDto.getHistory());
    }

    @Test
    public void mapToHistoryDtoList() {

        //Given
        List<History> histories = new ArrayList<>();
        histories.add(new History());
        histories.add(new History());

        //When
        List<HistoryDto> historyDto = historyMapper.mapToHistoryDtoList(histories);

        //Then
        Assert.assertEquals(2, historyDto.size());
    }
}