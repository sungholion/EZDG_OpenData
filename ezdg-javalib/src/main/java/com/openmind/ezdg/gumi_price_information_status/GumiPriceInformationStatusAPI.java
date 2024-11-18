package com.openmind.ezdg.gumi_price_information_status;

import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;

public class GumiPriceInformationStatusAPI extends AbstractAPI<GumiPriceInformationStatus> {

    public GumiPriceInformationStatusAPI() {
        super("/gumi_price_information_status");
    }

    public GumiPriceInformationStatusAPI page(int page) {
        return (GumiPriceInformationStatusAPI) super.page(page);
    }

    public GumiPriceInformationStatusAPI perPage(int perPage) {
        return (GumiPriceInformationStatusAPI) super.perPage(perPage);
    }

    public GumiPriceInformationStatusAPI itemName(String itemName) {
        uriBuilder.setParameter("itemName", String.valueOf(itemName));
        return this;
    }

    public GumiPriceInformationStatusAPI itemNameContaining(String itemName) {
        uriBuilder.setParameter("itemNameContaining", itemName);
        return this;
    }

    public GumiPriceInformationStatusAPI specificationUnit(String specificationUnit) {
        uriBuilder.setParameter("specificationUnit", String.valueOf(specificationUnit));
        return this;
    }

    public GumiPriceInformationStatusAPI specificationUnitContaining(String specificationUnit) {
        uriBuilder.setParameter("specificationUnitContaining", specificationUnit);
        return this;
    }

    public GumiPriceInformationStatusAPI average(Long average) {
        uriBuilder.setParameter("average", String.valueOf(average));
        return this;
    }

    public GumiPriceInformationStatusAPI averageLt(Long averageLt) {
        uriBuilder.setParameter("averageLt", String.valueOf(averageLt));
        return this;
    }

    public GumiPriceInformationStatusAPI averageLte(Long averageLte) {
        uriBuilder.setParameter("averageLte", String.valueOf(averageLte));
        return this;
    }

    public GumiPriceInformationStatusAPI averageGt(Long averageGt) {
        uriBuilder.setParameter("averageGt", String.valueOf(averageGt));
        return this;
    }

    public GumiPriceInformationStatusAPI averageGte(Long averageGte) {
        uriBuilder.setParameter("averageGte", String.valueOf(averageGte));
        return this;
    }
    public GumiPriceInformationStatusAPI seonsaneup(Long seonsaneup) {
        uriBuilder.setParameter("seonsaneup", String.valueOf(seonsaneup));
        return this;
    }

    public GumiPriceInformationStatusAPI seonsaneupLt(Long seonsaneupLt) {
        uriBuilder.setParameter("seonsaneupLt", String.valueOf(seonsaneupLt));
        return this;
    }

    public GumiPriceInformationStatusAPI seonsaneupLte(Long seonsaneupLte) {
        uriBuilder.setParameter("seonsaneupLte", String.valueOf(seonsaneupLte));
        return this;
    }

    public GumiPriceInformationStatusAPI seonsaneupGt(Long seonsaneupGt) {
        uriBuilder.setParameter("seonsaneupGt", String.valueOf(seonsaneupGt));
        return this;
    }

    public GumiPriceInformationStatusAPI seonsaneupGte(Long seonsaneupGte) {
        uriBuilder.setParameter("seonsaneupGte", String.valueOf(seonsaneupGte));
        return this;
    }
    public GumiPriceInformationStatusAPI goaeup(Long goaeup) {
        uriBuilder.setParameter("goaeup", String.valueOf(goaeup));
        return this;
    }

    public GumiPriceInformationStatusAPI goaeupLt(Long goaeupLt) {
        uriBuilder.setParameter("goaeupLt", String.valueOf(goaeupLt));
        return this;
    }

    public GumiPriceInformationStatusAPI goaeupLte(Long goaeupLte) {
        uriBuilder.setParameter("goaeupLte", String.valueOf(goaeupLte));
        return this;
    }

    public GumiPriceInformationStatusAPI goaeupGt(Long goaeupGt) {
        uriBuilder.setParameter("goaeupGt", String.valueOf(goaeupGt));
        return this;
    }

    public GumiPriceInformationStatusAPI goaeupGte(Long goaeupGte) {
        uriBuilder.setParameter("goaeupGte", String.valueOf(goaeupGte));
        return this;
    }
    public GumiPriceInformationStatusAPI wonpyeongShinpyeong(Long wonpyeongShinpyeong) {
        uriBuilder.setParameter("wonpyeongShinpyeong", String.valueOf(wonpyeongShinpyeong));
        return this;
    }

    public GumiPriceInformationStatusAPI wonpyeongShinpyeongLt(Long wonpyeongShinpyeongLt) {
        uriBuilder.setParameter("wonpyeongShinpyeongLt", String.valueOf(wonpyeongShinpyeongLt));
        return this;
    }

    public GumiPriceInformationStatusAPI wonpyeongShinpyeongLte(Long wonpyeongShinpyeongLte) {
        uriBuilder.setParameter("wonpyeongShinpyeongLte", String.valueOf(wonpyeongShinpyeongLte));
        return this;
    }

    public GumiPriceInformationStatusAPI wonpyeongShinpyeongGt(Long wonpyeongShinpyeongGt) {
        uriBuilder.setParameter("wonpyeongShinpyeongGt", String.valueOf(wonpyeongShinpyeongGt));
        return this;
    }

    public GumiPriceInformationStatusAPI wonpyeongShinpyeongGte(Long wonpyeongShinpyeongGte) {
        uriBuilder.setParameter("wonpyeongShinpyeongGte", String.valueOf(wonpyeongShinpyeongGte));
        return this;
    }
    public GumiPriceInformationStatusAPI doryangSeonjuWonnam(Long doryangSeonjuWonnam) {
        uriBuilder.setParameter("doryangSeonjuWonnam", String.valueOf(doryangSeonjuWonnam));
        return this;
    }

    public GumiPriceInformationStatusAPI doryangSeonjuWonnamLt(Long doryangSeonjuWonnamLt) {
        uriBuilder.setParameter("doryangSeonjuWonnamLt", String.valueOf(doryangSeonjuWonnamLt));
        return this;
    }

    public GumiPriceInformationStatusAPI doryangSeonjuWonnamLte(Long doryangSeonjuWonnamLte) {
        uriBuilder.setParameter("doryangSeonjuWonnamLte", String.valueOf(doryangSeonjuWonnamLte));
        return this;
    }

    public GumiPriceInformationStatusAPI doryangSeonjuWonnamGt(Long doryangSeonjuWonnamGt) {
        uriBuilder.setParameter("doryangSeonjuWonnamGt", String.valueOf(doryangSeonjuWonnamGt));
        return this;
    }

    public GumiPriceInformationStatusAPI doryangSeonjuWonnamGte(Long doryangSeonjuWonnamGte) {
        uriBuilder.setParameter("doryangSeonjuWonnamGte", String.valueOf(doryangSeonjuWonnamGte));
        return this;
    }
    public GumiPriceInformationStatusAPI songjeongHyeonggok(Long songjeongHyeonggok) {
        uriBuilder.setParameter("songjeongHyeonggok", String.valueOf(songjeongHyeonggok));
        return this;
    }

    public GumiPriceInformationStatusAPI songjeongHyeonggokLt(Long songjeongHyeonggokLt) {
        uriBuilder.setParameter("songjeongHyeonggokLt", String.valueOf(songjeongHyeonggokLt));
        return this;
    }

    public GumiPriceInformationStatusAPI songjeongHyeonggokLte(Long songjeongHyeonggokLte) {
        uriBuilder.setParameter("songjeongHyeonggokLte", String.valueOf(songjeongHyeonggokLte));
        return this;
    }

    public GumiPriceInformationStatusAPI songjeongHyeonggokGt(Long songjeongHyeonggokGt) {
        uriBuilder.setParameter("songjeongHyeonggokGt", String.valueOf(songjeongHyeonggokGt));
        return this;
    }

    public GumiPriceInformationStatusAPI songjeongHyeonggokGte(Long songjeongHyeonggokGte) {
        uriBuilder.setParameter("songjeongHyeonggokGte", String.valueOf(songjeongHyeonggokGte));
        return this;
    }
    public GumiPriceInformationStatusAPI yangpoSong(Long yangpoSong) {
        uriBuilder.setParameter("yangpoSong", String.valueOf(yangpoSong));
        return this;
    }

    public GumiPriceInformationStatusAPI yangpoSongLt(Long yangpoSongLt) {
        uriBuilder.setParameter("yangpoSongLt", String.valueOf(yangpoSongLt));
        return this;
    }

    public GumiPriceInformationStatusAPI yangpoSongLte(Long yangpoSongLte) {
        uriBuilder.setParameter("yangpoSongLte", String.valueOf(yangpoSongLte));
        return this;
    }

    public GumiPriceInformationStatusAPI yangpoSongGt(Long yangpoSongGt) {
        uriBuilder.setParameter("yangpoSongGt", String.valueOf(yangpoSongGt));
        return this;
    }

    public GumiPriceInformationStatusAPI yangpoSongGte(Long yangpoSongGte) {
        uriBuilder.setParameter("yangpoSongGte", String.valueOf(yangpoSongGte));
        return this;
    }
    public GumiPriceInformationStatusAPI sangmoSagokImo(Long sangmoSagokImo) {
        uriBuilder.setParameter("sangmoSagokImo", String.valueOf(sangmoSagokImo));
        return this;
    }

    public GumiPriceInformationStatusAPI sangmoSagokImoLt(Long sangmoSagokImoLt) {
        uriBuilder.setParameter("sangmoSagokImoLt", String.valueOf(sangmoSagokImoLt));
        return this;
    }

    public GumiPriceInformationStatusAPI sangmoSagokImoLte(Long sangmoSagokImoLte) {
        uriBuilder.setParameter("sangmoSagokImoLte", String.valueOf(sangmoSagokImoLte));
        return this;
    }

    public GumiPriceInformationStatusAPI sangmoSagokImoGt(Long sangmoSagokImoGt) {
        uriBuilder.setParameter("sangmoSagokImoGt", String.valueOf(sangmoSagokImoGt));
        return this;
    }

    public GumiPriceInformationStatusAPI sangmoSagokImoGte(Long sangmoSagokImoGte) {
        uriBuilder.setParameter("sangmoSagokImoGte", String.valueOf(sangmoSagokImoGte));
        return this;
    }
    public GumiPriceInformationStatusAPI indongJinmi(Long indongJinmi) {
        uriBuilder.setParameter("indongJinmi", String.valueOf(indongJinmi));
        return this;
    }

    public GumiPriceInformationStatusAPI indongJinmiLt(Long indongJinmiLt) {
        uriBuilder.setParameter("indongJinmiLt", String.valueOf(indongJinmiLt));
        return this;
    }

    public GumiPriceInformationStatusAPI indongJinmiLte(Long indongJinmiLte) {
        uriBuilder.setParameter("indongJinmiLte", String.valueOf(indongJinmiLte));
        return this;
    }

    public GumiPriceInformationStatusAPI indongJinmiGt(Long indongJinmiGt) {
        uriBuilder.setParameter("indongJinmiGt", String.valueOf(indongJinmiGt));
        return this;
    }

    public GumiPriceInformationStatusAPI indongJinmiGte(Long indongJinmiGte) {
        uriBuilder.setParameter("indongJinmiGte", String.valueOf(indongJinmiGte));
        return this;
    }
    public GumiPriceInformationStatusAPI dataBaseDate(LocalDate dataBaseDate) {
        uriBuilder.setParameter("dataBaseDate", String.valueOf(dataBaseDate));
        return this;
    }

    public GumiPriceInformationStatusAPI dataBaseDateAfter(LocalDate dataBaseDateAfter) {
        uriBuilder.setParameter("dataBaseDateAfter", dataBaseDateAfter.toString());
        return this;
    }

    public GumiPriceInformationStatusAPI dataBaseDateBefore(LocalDate dataBaseDateBefore) {
        uriBuilder.setParameter("dataBaseDateBefore", dataBaseDateBefore.toString());
        return this;
    }

}