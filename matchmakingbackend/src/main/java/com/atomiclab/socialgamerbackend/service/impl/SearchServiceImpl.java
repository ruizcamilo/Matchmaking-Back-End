package com.atomiclab.socialgamerbackend.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.atomiclab.socialgamerbackend.domain.model.Games;
import com.atomiclab.socialgamerbackend.domain.model.Post;
import com.atomiclab.socialgamerbackend.domain.model.User;
import com.atomiclab.socialgamerbackend.repository.FirebaseCrud;
import com.atomiclab.socialgamerbackend.service.SearchService;
import com.google.cloud.firestore.DocumentSnapshot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    FirebaseCrud firebaseCrud;

    public List<User> searchUser(String collectionName, String searchWord)
            throws InterruptedException, ExecutionException {
        List<User> personasResult = new ArrayList<>();
        for (DocumentSnapshot doc : firebaseCrud.getCollection(collectionName).get().get().getDocuments()) {
            User userAux = doc.toObject(User.class);
            if (userAux.getNombre_usuario().toLowerCase().contains(searchWord.toLowerCase().trim())) {
                personasResult.add(userAux);
            }
        }
        return personasResult;
    }

    public List<Games> searchGames(String collectionName, String searchWord)
            throws InterruptedException, ExecutionException {
        List<Games> juegosResult = new ArrayList<>();
        ;
        for (DocumentSnapshot doc : firebaseCrud.getCollection(collectionName).get().get().getDocuments()) {
            Games gamesAux = doc.toObject(Games.class);
            if (gamesAux.getNombre().toLowerCase().contains(searchWord.toLowerCase().trim())) {
                juegosResult.add(gamesAux);
            }
        }
        return juegosResult;
    }

    public List<Post> searchPost(String collectionName, String searchWord)
            throws InterruptedException, ExecutionException {
        List<Post> postResult = new ArrayList<>();
        for (DocumentSnapshot doc : firebaseCrud.getCollection(collectionName).get().get().getDocuments()) {
            Post postAux = doc.toObject(Post.class);
            if (postAux.getContenido().toLowerCase().contains(searchWord.toLowerCase().trim())) {
                postResult.add(postAux);
            }
        }
        return postResult;
    }
}
