package com.backend.gamesjar.communicator.controller;

import com.backend.gamesjar.communicator.domain.HistoryDto;
import com.backend.gamesjar.communicator.mapper.HistoryMapper;
import com.backend.gamesjar.communicator.service.HistoryService;
import com.backend.gamesjar.domain.GameDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/gamesjar")
public class ConnectionController {
    @Autowired
    private HistoryService historyService;

    @Autowired
    private HistoryMapper historyMapper;

    @RequestMapping(value = "/history/{historyId}", method = RequestMethod.PUT)
    public void sentText(@RequestBody String text, @PathVariable Long historyId) throws Exception {
        historyMapper.mapToHistoryDto(historyService.addHistory(text, historyId));
    }

    @RequestMapping(value = "/history/{historyId}", method = RequestMethod.GET)
    public HistoryDto getHistory(@PathVariable Long historyId) throws Exception {
        return historyMapper.mapToHistoryDto(historyService.getHistory(historyId));
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public List<HistoryDto> historyList() {
        return historyMapper.mapToHistoryDtoList(historyService.getAllHistories());
    }

    @RequestMapping(value = "/history", method = RequestMethod.POST)
    public void createHistory(@RequestBody HistoryDto historyDto) {
        historyService.createHistory(historyMapper.mapToHistory(historyDto));
    }

    @RequestMapping(value = "/history/{historyId}", method = RequestMethod.DELETE)
    public void deleteHistory(@PathVariable Long historyId) {
        historyService.deleteHistory(historyId);
    }
}
