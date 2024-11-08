package com.openmind.ezdg.user.repository;

import com.openmind.ezdg.user.entity.DataApplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataApplyRepository extends JpaRepository<DataApplyEntity, Integer> {
}
