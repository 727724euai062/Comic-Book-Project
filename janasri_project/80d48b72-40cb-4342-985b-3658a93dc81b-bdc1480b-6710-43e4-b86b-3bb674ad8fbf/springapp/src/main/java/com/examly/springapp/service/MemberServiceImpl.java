package com.examly.springapp.service;

import com.examly.springapp.model.Member;
import com.examly.springapp.repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepo memberRepo;

    @Override
    public Member add(Member member) {
        return memberRepo.save(member);
    }

    @Override
    public List<Member> getAll() {
        return memberRepo.findAll();
    }

    @Override
    public Member getById(Long id) {
        return memberRepo.findById(id).orElse(null);
    }

    @Override
    public Member update(Long id, Member member) {
        member.setMemberId(id);
        return memberRepo.save(member);
    }

    @Override
    public List<Member> getByPhone(String phone) {
        return memberRepo.findByPhone(phone);
    }

    @Override
    public List<Member> getByEmail(String email) {
        return memberRepo.findByEmail(email);
    }
}
