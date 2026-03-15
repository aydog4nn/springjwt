package com.aydog4nn.repository;

import com.aydog4nn.model.Personel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonelRepository extends JpaRepository<Personel,Long> {



}
