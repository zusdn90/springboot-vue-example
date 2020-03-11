package com.riding.springboot.service.user;


import com.riding.springboot.domain.entity.User;
import com.riding.springboot.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// UserService.java는 데이터를 컨트롤러에서 받아 받은 데이터로 쿼리를 수행하여 나온 결과를 다시
// 컨트롤러에 전달해주는 역할을 한다.
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // insert 쿼리 수행
    public void userInsert(User user){
        userRepository.save(user);
    }

    // select 쿼리 수행
    public Iterable<User> userSelect() {
        return userRepository.findAll();
    }

    // delete 쿼리 수행
    public void userDelete(long id){
        userRepository.deleteById(id);
    }

}
