package com.personalproject.workshopmongo.services;

import com.personalproject.workshopmongo.domain.Post;
import com.personalproject.workshopmongo.repositories.PostRepository;
import com.personalproject.workshopmongo.services.exeptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;




    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return  obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repository.searchTitle(text);
    }

    public List<Post> fullsearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() +24 * 60 * 60 * 1000);
        return repository.fullSearch(text, minDate, maxDate);
    }
}
