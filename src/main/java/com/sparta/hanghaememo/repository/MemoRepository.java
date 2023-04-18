package com.sparta.hanghaememo.repository;


import com.sparta.hanghaememo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemoRepository extends JpaRepository<Memo, Long> {



    // select * from memo order by modified desc;
    List<Memo> findAllByOrderByModifiedAtDesc();

    //select * from memo order by id = id and password = password;
    Memo findByIdAndPassword(Long id, String password);

    Optional<Object> findById(String password);
}