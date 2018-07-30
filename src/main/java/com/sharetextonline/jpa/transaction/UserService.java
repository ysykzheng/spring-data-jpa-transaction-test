package com.sharetextonline.jpa.transaction;

import javax.transaction.Transactional;

public interface UserService {
  void insert(String name,Long sleep);

  @Transactional
  void insert2(String name, Long sleep);

  void list();
}
