package com.openmind.ezdg_api_server.gumi_price_information_status;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;


@Getter
@Setter
@Document(collection = "gumi_price_information_status")
public class GumiPriceInformationStatus {
    @Id
    private String id;
    private String itemName;
    private String specificationUnit;
    private Long average;
    private Long seonsaneup;
    private Long goaeup;
    private Long wonpyeongShinpyeong;
    private Long doryangSeonjuWonnam;
    private Long songjeongHyeonggok;
    private Long yangpoSong;
    private Long sangmoSagokImo;
    private Long indongJinmi;
    private LocalDate dataBaseDate;
}