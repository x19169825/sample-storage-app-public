package com.compproject.samplestorageapp.repositories;

import com.compproject.samplestorageapp.model.users.EndUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<EndUser, String> {
    EndUser findByUsername(String username);
}
