package com.examly.springapp.service;

import com.examly.springapp.model.Member;

import java.util.List;

public interface MemberService {

    Member add(Member member);

    List<Member> getAll();

    Member getById(Long id);

    Member update(Long id, Member member);

    List<Member> getByPhone(String phone);

    List<Member> getByEmail(String email);
}
