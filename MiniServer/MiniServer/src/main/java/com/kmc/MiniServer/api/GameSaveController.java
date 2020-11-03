package com.kmc.MiniServer.api;

import com.kmc.MiniServer.model.GameSave;
import com.kmc.MiniServer.service.GameSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("plantville/api/save/")
@RestController
public class GameSaveController {

    private GameSaveService gameSaveService;

    @Autowired
    public GameSaveController(GameSaveService gameSaveService) {
        this.gameSaveService = gameSaveService;
    }

    @PostMapping(path = "{username}")
    public void saveGame(@PathVariable("username") String username,@RequestBody GameSave save){
        gameSaveService.insertSave(username, save);
    }

    @GetMapping
    public Map<String, GameSave> getAllSaves(){
        return gameSaveService.allSaves();
    }

    @GetMapping("{username}")
    public GameSave getSaveByName(@PathVariable("username") String username){
        return gameSaveService.selectSaveByName(username).orElse(null);
    }

    @DeleteMapping("{username}")
    public int deleteSaveByName(@PathVariable("username") String username){
        return gameSaveService.deleteSaveByName(username);
    }
}
