package com.openmind.ezdg.user.entity;

import com.openmind.ezdg.user.dto.DataApplyDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "data_apply")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataApplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private String association;

    @Column(nullable = false)
    private String publicDataName;

    @Column(nullable = false)
    private String publicDataLink;

    @Column(nullable = false)
    private String publicDataType;

    @Column(nullable = false)
    private String purpose;

    private String additionalRequest;

    @Column(nullable = false)
    private Boolean isAccepted = false;  // 기본값을 false로 설정

    // DTO를 Entity로 변환하는 정적 메서드
    public static DataApplyEntity toSaveEntity(DataApplyDto dto) {
        return DataApplyEntity.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .association(dto.getAssociation())
                .publicDataName(dto.getPublicDataName())
                .publicDataLink(dto.getPublicDataLink())
                .publicDataType(dto.getPublicDataType())
                .purpose(dto.getPurpose())
                .additionalRequest(dto.getAdditionalRequest())
                .isAccepted(false) // 기본값 설정
                .build();
    }
}
