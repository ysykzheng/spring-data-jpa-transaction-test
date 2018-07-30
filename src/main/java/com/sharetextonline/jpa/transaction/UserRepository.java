package com.sharetextonline.jpa.transaction;

import java.util.List;
import javax.persistence.LockModeType;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

  @Lock(LockModeType.PESSIMISTIC_WRITE)
  List<User> findByName(String name);

}
