package com.ynu.makeup_you.service;

import com.ynu.makeup_you.entity.CommDoubleKey;
import com.ynu.makeup_you.entity.Likes;
import com.ynu.makeup_you.repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2019/5/16 0016
 * BY hujianlong
 */
@Service
public class LikesServiceImpl implements LikesService {

    @Autowired
    private LikesRepository likesRepository;

    @Override
    public void addRecord(Likes likes) {
        likesRepository.save(likes);
    }

    @Override
    public void deleteRecord(String userID, String postID) {
        CommDoubleKey likesKey = new CommDoubleKey();
        likesKey.setUserID(userID);
        likesKey.setPostID(postID);
        likesRepository.deleteById(likesKey);
    }

    @Override
    public List<Likes> getAllLikes(String userID) {
        return likesRepository.findByUserID(userID);
    }

    @Override
    public List<Likes> getAlluser(String postID) {
        return likesRepository.findByPostID(postID);
    }
}
