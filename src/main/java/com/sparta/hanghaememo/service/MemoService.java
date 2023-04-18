package com.sparta.hanghaememo.service;

import com.sparta.hanghaememo.dto.InsertMemoDto;
import com.sparta.hanghaememo.dto.MemoRequestDto;
import com.sparta.hanghaememo.entity.Memo;
import com.sparta.hanghaememo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;

    @Transactional
    public Memo  createMemo(MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto); //Entity 생성
        memoRepository.save(memo);
        return memo;
    }

    @Transactional(readOnly = true)
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );
        memo.update(requestDto);
        return memo.getId();
    }

    @Transactional
    public Long deleteMemo(Long id) {
        memoRepository.deleteById(id);
        return id;
    }

//    @Transactional
//    public Long deletechooseMemo(Long id, String password){
//        password = "1234";
//        memoRepository.findById(Long.valueOf(password));
//        memoRepository.deleteById(id);
//        return id;
//    }

    @Transactional
    public List<Memo> InsertMemo(InsertMemoDto insertMemoDto){
       Memo memo = new Memo();
       memo.Insert(insertMemoDto);
       memoRepository.save(memo);
       return  memoRepository.findAllByOrderByModifiedAtDesc();
    }


    // 선택한 게시글 제목, 작성자명, 작성 날짜, 작성 내용 조회
    @Transactional
    public List<Memo> getchooseMemo(Long num){
        Memo memo = memoRepository.findById(num).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional
    public Memo updatechoseMemo(Long id, String password){
        memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );

        System.out.println("패스워드 : "+ password);
        memoRepository.findById(password).orElseThrow(
                () -> new IllegalArgumentException("패스워드가 일치 하지 않습니다")
        );

        Memo memo =  memoRepository.findByIdAndPassword(id,password);
        System.out.println("메모리스트 : "+ memo);
        return memo;
    }
}
