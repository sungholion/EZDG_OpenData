package com.openmind.ezdg.file.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "public_data_code")
public class PublicDataCode {
    @Id
    private String id;
    
    // 공공데이터 각 데이터 별 식별코드
    private String code;
    
    // 코드 저장 일시
    private LocalDateTime regDate;
}
