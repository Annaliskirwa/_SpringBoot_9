package com.example.reddis_example.repository;

import com.example.reddis_example.models.RedisModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReddisRepository extends CrudRepository<RedisModel, Long> {
}
