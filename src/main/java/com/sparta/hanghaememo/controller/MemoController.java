package com.sparta.hanghaememo.controller;

import com.sparta.hanghaememo.dto.InsertMemoDto;
import com.sparta.hanghaememo.dto.MemoRequestDto;
import com.sparta.hanghaememo.entity.Memo;
import com.sparta.hanghaememo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @GetMapping("/") // 기본페이지로 이동하는 컨트롤러
    public ModelAndView home(){
        return new ModelAndView("index");
    }

    @PostMapping("/api/memos") // 메모를 db에 저장하는 컨트롤러
    public Memo createMemo(@RequestBody MemoRequestDto requestDto){
        return memoService.createMemo(requestDto);
    }

    @GetMapping("/api/memos")  // db에 저장된 메모리스트 가져오는 컨트롤러
    public List<Memo> getMemos(){
        return memoService.getMemos();
    }

    @PutMapping("/api/memos/{id}") // 선택한 메모 수정하는 컨트롤러
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        return memoService.update(id, requestDto);
    }

    @DeleteMapping("/api/memos/{id}") // 선택한 메모 삭제하는 컨트롤러
    public Long deleteMemo(@PathVariable Long id){
        return memoService.deleteMemo(id);
    }

    // 전체 게시글 목록 조회 API
    //- 제목, 작성자명, 작성 내용, 작성 날짜를 조회하기
    //- 작성 날짜 기준 내림차순으로 정렬하기
    @GetMapping("/api/posts")
    public List<Memo> getposts(){
        return memoService.getMemos();
    }

    // 게시글 작성 API
    //- 제목, 작성자명, 비밀번호, 작성 내용을 저장하고
    //- 저장된 게시글을 Client 로 반환하기
    @PostMapping("/api/post")
    public List<Memo> getMemopost(InsertMemoDto InsertMemoDto){
        return memoService.InsertMemo(InsertMemoDto);
    }

    // 선택한 게시글 조회 API
    // - 선택한 게시글의 제목, 작성자명, 작성 날짜, 작성 내용을 조회하기
    // (검색 기능이 아닙니다. 간단한 게시글 조회만 구현해주세요.)
    @GetMapping("/api/post/{id}")
    public List<Memo> getchooseMemo(@PathVariable Long num){
        return memoService.getchooseMemo(num);
    }


    // 5. 선택한 게시글 수정 API
    //**`화요일 17:00까지 완료`**
    // - 수정을 요청할 때 수정할 데이터와 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부를 확인 한 후
    // - 제목, 작성자명, 작성 내용을 수정하고 수정된 게시글을 Client 로 반환하기
    @PutMapping("/api/post/{id}")
    public void updatechoseMemo(@PathVariable Long id, String password){
        memoService.updatechoseMemo(id,password);
    }

    // 6. 선택한 게시글 삭제 API
    //**`수요일 17:00까지 완료`**
    // - 삭제를 요청할 때 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부를 확인 한 후
    // - 선택한 게시글을 삭제하고 Client 로 성공했다는 표시 반환하기
//    @DeleteMapping("/api/post/{id}")
//    public Long deletechooseMemo(@PathVariable Long id, String password){
//
//        return null;
//    }
}
