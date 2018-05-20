package com.lch.springboot03.repository;

import com.lch.springboot03.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User,Long>{

    User findById(long id);
    void deleteById(Long id);
}
