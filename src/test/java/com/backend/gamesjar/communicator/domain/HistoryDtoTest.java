package com.backend.gamesjar.communicator.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HistoryDtoTest {

    private HistoryDto historyDto = new HistoryDto(1L, "history");

    @Test
    public void getId() {
        Assert.assertEquals(1L, historyDto.getId(), 0.001);
    }

    @Test
    public void getHistory() {
        Assert.assertEquals("history", historyDto.getHistory());
    }
}