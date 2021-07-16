package com.csr.repo;

import com.csr.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmployeeId(String employeeId);

}
