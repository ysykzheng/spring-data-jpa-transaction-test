package com.sharetextonline.jpa.transaction;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  @Override
  public void insert(String name,Long sleep){
    List<User> resultList = userRepository.findByName(name);
    resultList.stream().forEach(user -> log.info(user.toString()));
    try {
      Thread.sleep(sleep);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    if (resultList.isEmpty()) {
      User user = User.builder().name(name).build();
      userRepository.save(user);
      log.info("create:"+user.getId());
    }
  }

  @Transactional
  @Override
  public void insert2(String name, Long sleep){

    TypedQuery<User> query = entityManager.createQuery("select u from User u where u.name=?1", User.class);
    query.setLockMode(LockModeType.PESSIMISTIC_WRITE);
    query.setParameter(1,name);
    List<User> resultList = query.getResultList();
    resultList.stream().forEach(user -> log.info(user.toString()));
    try {
      Thread.sleep(sleep);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    if (resultList.isEmpty()) {
      User user = User.builder().name(name).build();
      userRepository.save(user);
      log.info("create:"+user.getId());
    }
  }

  @Override
  public void list(){
    userRepository.findAll().forEach(user -> log.info(user.toString()));
  }

}
