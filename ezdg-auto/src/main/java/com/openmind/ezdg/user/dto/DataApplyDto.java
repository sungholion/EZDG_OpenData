package com.openmind.ezdg.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DataApplyDto {
    @NotBlank(message = "이름은 필수 입력 항목입니다.")
    private String name;

    @NotBlank(message = "답변 받을 이메일은 필수 입력 항목입니다.")
    @Email(message = "유효한 이메일 주소를 입력하세요.")
    private String email;

    private String association;

    @NotBlank(message = "공공 데이터 명칭은 필수 입력 항목입니다.")
    private String publicDataName;

    @NotBlank(message = "공공 데이터 링크는 필수 입력 항목입니다.")
    private String publicDataLink;

    @NotBlank(message = "공공 데이터 타입은 필수 입력 항목입니다.")
    private String publicDataType;

    @NotBlank(message = "활용 목적은 필수 입력 항목입니다.")
    private String purpose;

    private String additionalRequest;

    private Boolean isAccepted;



}
