package com.qin.dao;

import com.qin.bean.Depart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartRepository extends JpaRepository<Depart, Integer> {
}
