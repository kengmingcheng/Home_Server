package com.kmc.MiniServer.service;

import com.kmc.MiniServer.dao.PlantvilleDao;
import com.kmc.MiniServer.model.GameSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class GameSaveService {

    private PlantvilleDao pDao;

    @Autowired
    public GameSaveService(PlantvilleDao pDao) {
        this.pDao = pDao;
    }

    public int insertSave(String name, GameSave save){
        return pDao.insertSave(name, save);
    }

    public Map<String, GameSave> allSaves(){
        return pDao.allSaves();
    }

    public Optional<GameSave> selectSaveByName(String name){
        return pDao.selectSaveByName(name);
    }

    public int deleteSaveByName(String name){
        return pDao.deleteSaveByName(name);
    }
}
