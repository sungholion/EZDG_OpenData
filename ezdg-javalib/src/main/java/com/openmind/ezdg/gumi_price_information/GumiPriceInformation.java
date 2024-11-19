package com.openmind.ezdg.gumi_price_information;

import java.time.LocalDate;

public class GumiPriceInformation {

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

    // Getters and Setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSpecificationUnit() {
        return specificationUnit;
    }

    public void setSpecificationUnit(String specificationUnit) {
        this.specificationUnit = specificationUnit;
    }

    public Long getAverage() {
        return average;
    }

    public void setAverage(Long average) {
        this.average = average;
    }

    public Long getSeonsaneup() {
        return seonsaneup;
    }

    public void setSeonsaneup(Long seonsaneup) {
        this.seonsaneup = seonsaneup;
    }

    public Long getGoaeup() {
        return goaeup;
    }

    public void setGoaeup(Long goaeup) {
        this.goaeup = goaeup;
    }

    public Long getWonpyeongShinpyeong() {
        return wonpyeongShinpyeong;
    }

    public void setWonpyeongShinpyeong(Long wonpyeongShinpyeong) {
        this.wonpyeongShinpyeong = wonpyeongShinpyeong;
    }

    public Long getDoryangSeonjuWonnam() {
        return doryangSeonjuWonnam;
    }

    public void setDoryangSeonjuWonnam(Long doryangSeonjuWonnam) {
        this.doryangSeonjuWonnam = doryangSeonjuWonnam;
    }

    public Long getSongjeongHyeonggok() {
        return songjeongHyeonggok;
    }

    public void setSongjeongHyeonggok(Long songjeongHyeonggok) {
        this.songjeongHyeonggok = songjeongHyeonggok;
    }

    public Long getYangpoSong() {
        return yangpoSong;
    }

    public void setYangpoSong(Long yangpoSong) {
        this.yangpoSong = yangpoSong;
    }

    public Long getSangmoSagokImo() {
        return sangmoSagokImo;
    }

    public void setSangmoSagokImo(Long sangmoSagokImo) {
        this.sangmoSagokImo = sangmoSagokImo;
    }

    public Long getIndongJinmi() {
        return indongJinmi;
    }

    public void setIndongJinmi(Long indongJinmi) {
        this.indongJinmi = indongJinmi;
    }

    public LocalDate getDataBaseDate() {
        return dataBaseDate;
    }

    public void setDataBaseDate(LocalDate dataBaseDate) {
        this.dataBaseDate = dataBaseDate;
    }

}
