package com.ynu.makeup_you.service;

import com.ynu.makeup_you.entity.CommDoubleKey;
import com.ynu.makeup_you.entity.Favorites;
import com.ynu.makeup_you.repository.FavoritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2019/5/15
 * BY hujianlong
 */

@Service
public class FavoritesServiceImpl implements FavoritesService {

    @Autowired
    private FavoritesRepository favoritesRepository;

    @Override
    public void addRecord(Favorites favorites) {
        favoritesRepository.save(favorites);
    }

    @Override
    public void deleteRecord(String userID, String postID) {
        CommDoubleKey favoritesKey = new CommDoubleKey();
        favoritesKey.setUserID(userID);
        favoritesKey.setPostID(postID);
        favoritesRepository.deleteById(favoritesKey);
    }

    @Override
    public List<Favorites> getAllfavorites(String userID) {
        return favoritesRepository.findByUserID(userID);
    }

    @Override
    public List<Favorites> getAlluser(String postID) {
        return favoritesRepository.findByPostID(postID);
    }

}
