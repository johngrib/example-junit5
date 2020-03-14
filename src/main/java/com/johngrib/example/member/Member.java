package com.johngrib.example.member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Member {
  public Member() {
  }

  public Member(String name) {
    this.name = name;
    this.visited = 0;
  }

  public Member(String name, int visited) {
    this.name = name;
    this.visited = visited;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private int visited;
}

