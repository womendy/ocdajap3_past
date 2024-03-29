package com.oc.rental.repository.impl;

import com.oc.rental.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends CrudRepository<User,Long> {
}
