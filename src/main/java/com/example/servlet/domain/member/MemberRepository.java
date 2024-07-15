package com.example.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//동시성 문제는 고려 안함. 실무에서는 컨커런트해쉬맵 , 아토믹롱 등 사용 고려 ( 컨커런트해쉬맵을 잘 쓰지 않기는 함 )

public class MemberRepository {

    private Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }
    private MemberRepository(){

    } //생성자 막아서 막 만들지못하게해야 싱글톤 유지 가능.

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values()); //스토어 자체를 보내버리면 조작이 가능해져버림
    }

    public void clearStore(){
        store.clear();
    }
}
