package com.sharetextonline.jpa.transaction;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue
  private Integer id;

  @Column
  private String name;

  @CreationTimestamp
  @Column
  private Date createTime;

  @UpdateTimestamp
  @Column
  private Date updateTime;

}
