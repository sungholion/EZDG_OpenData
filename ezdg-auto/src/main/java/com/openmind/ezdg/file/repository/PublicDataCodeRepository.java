package com.openmind.ezdg.file.repository;

import com.openmind.ezdg.file.entity.PublicDataCode;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PublicDataCodeRepository extends MongoRepository<PublicDataCode, String> {
    /**
     * code로 조회
     * @param code
     * @return Optional 반환
     */
    Optional<PublicDataCode> findByCode(String code);
}
