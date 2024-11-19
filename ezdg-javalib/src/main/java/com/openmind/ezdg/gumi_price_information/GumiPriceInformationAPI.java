package com.openmind.ezdg.gumi_price_information;

import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;

public class GumiPriceInformationAPI extends AbstractAPI<GumiPriceInformation> {

    public GumiPriceInformationAPI() {
        super("/gumi_price_information");
    }

    public GumiPriceInformationAPI page(int page) {
        return (GumiPriceInformationAPI) super.page(page);
    }

    public GumiPriceInformationAPI perPage(int perPage) {
        return (GumiPriceInformationAPI) super.perPage(perPage);
    }

    public GumiPriceInformationAPI itemName(String itemName) {
        uriBuilder.setParameter("itemName", String.valueOf(itemName));
        return this;
    }

    public GumiPriceInformationAPI itemNameContaining(String itemName) {
        uriBuilder.setParameter("itemNameContaining", itemName);
        return this;
    }

    public GumiPriceInformationAPI specificationUnit(String specificationUnit) {
        uriBuilder.setParameter("specificationUnit", String.valueOf(specificationUnit));
        return this;
    }

    public GumiPriceInformationAPI specificationUnitContaining(String specificationUnit) {
        uriBuilder.setParameter("specificationUnitContaining", specificationUnit);
        return this;
    }

    public GumiPriceInformationAPI average(Long average) {
        uriBuilder.setParameter("average", String.valueOf(average));
        return this;
    }

    public GumiPriceInformationAPI averageLt(Long averageLt) {
        uriBuilder.setParameter("averageLt", String.valueOf(averageLt));
        return this;
    }

    public GumiPriceInformationAPI averageLte(Long averageLte) {
        uriBuilder.setParameter("averageLte", String.valueOf(averageLte));
        return this;
    }

    public GumiPriceInformationAPI averageGt(Long averageGt) {
        uriBuilder.setParameter("averageGt", String.valueOf(averageGt));
        return this;
    }

    public GumiPriceInformationAPI averageGte(Long averageGte) {
        uriBuilder.setParameter("averageGte", String.valueOf(averageGte));
        return this;
    }
    public GumiPriceInformationAPI seonsaneup(Long seonsaneup) {
        uriBuilder.setParameter("seonsaneup", String.valueOf(seonsaneup));
        return this;
    }

    public GumiPriceInformationAPI seonsaneupLt(Long seonsaneupLt) {
        uriBuilder.setParameter("seonsaneupLt", String.valueOf(seonsaneupLt));
        return this;
    }

    public GumiPriceInformationAPI seonsaneupLte(Long seonsaneupLte) {
        uriBuilder.setParameter("seonsaneupLte", String.valueOf(seonsaneupLte));
        return this;
    }

    public GumiPriceInformationAPI seonsaneupGt(Long seonsaneupGt) {
        uriBuilder.setParameter("seonsaneupGt", String.valueOf(seonsaneupGt));
        return this;
    }

    public GumiPriceInformationAPI seonsaneupGte(Long seonsaneupGte) {
        uriBuilder.setParameter("seonsaneupGte", String.valueOf(seonsaneupGte));
        return this;
    }
    public GumiPriceInformationAPI goaeup(Long goaeup) {
        uriBuilder.setParameter("goaeup", String.valueOf(goaeup));
        return this;
    }

    public GumiPriceInformationAPI goaeupLt(Long goaeupLt) {
        uriBuilder.setParameter("goaeupLt", String.valueOf(goaeupLt));
        return this;
    }

    public GumiPriceInformationAPI goaeupLte(Long goaeupLte) {
        uriBuilder.setParameter("goaeupLte", String.valueOf(goaeupLte));
        return this;
    }

    public GumiPriceInformationAPI goaeupGt(Long goaeupGt) {
        uriBuilder.setParameter("goaeupGt", String.valueOf(goaeupGt));
        return this;
    }

    public GumiPriceInformationAPI goaeupGte(Long goaeupGte) {
        uriBuilder.setParameter("goaeupGte", String.valueOf(goaeupGte));
        return this;
    }
    public GumiPriceInformationAPI wonpyeongShinpyeong(Long wonpyeongShinpyeong) {
        uriBuilder.setParameter("wonpyeongShinpyeong", String.valueOf(wonpyeongShinpyeong));
        return this;
    }

    public GumiPriceInformationAPI wonpyeongShinpyeongLt(Long wonpyeongShinpyeongLt) {
        uriBuilder.setParameter("wonpyeongShinpyeongLt", String.valueOf(wonpyeongShinpyeongLt));
        return this;
    }

    public GumiPriceInformationAPI wonpyeongShinpyeongLte(Long wonpyeongShinpyeongLte) {
        uriBuilder.setParameter("wonpyeongShinpyeongLte", String.valueOf(wonpyeongShinpyeongLte));
        return this;
    }

    public GumiPriceInformationAPI wonpyeongShinpyeongGt(Long wonpyeongShinpyeongGt) {
        uriBuilder.setParameter("wonpyeongShinpyeongGt", String.valueOf(wonpyeongShinpyeongGt));
        return this;
    }

    public GumiPriceInformationAPI wonpyeongShinpyeongGte(Long wonpyeongShinpyeongGte) {
        uriBuilder.setParameter("wonpyeongShinpyeongGte", String.valueOf(wonpyeongShinpyeongGte));
        return this;
    }
    public GumiPriceInformationAPI doryangSeonjuWonnam(Long doryangSeonjuWonnam) {
        uriBuilder.setParameter("doryangSeonjuWonnam", String.valueOf(doryangSeonjuWonnam));
        return this;
    }

    public GumiPriceInformationAPI doryangSeonjuWonnamLt(Long doryangSeonjuWonnamLt) {
        uriBuilder.setParameter("doryangSeonjuWonnamLt", String.valueOf(doryangSeonjuWonnamLt));
        return this;
    }

    public GumiPriceInformationAPI doryangSeonjuWonnamLte(Long doryangSeonjuWonnamLte) {
        uriBuilder.setParameter("doryangSeonjuWonnamLte", String.valueOf(doryangSeonjuWonnamLte));
        return this;
    }

    public GumiPriceInformationAPI doryangSeonjuWonnamGt(Long doryangSeonjuWonnamGt) {
        uriBuilder.setParameter("doryangSeonjuWonnamGt", String.valueOf(doryangSeonjuWonnamGt));
        return this;
    }

    public GumiPriceInformationAPI doryangSeonjuWonnamGte(Long doryangSeonjuWonnamGte) {
        uriBuilder.setParameter("doryangSeonjuWonnamGte", String.valueOf(doryangSeonjuWonnamGte));
        return this;
    }
    public GumiPriceInformationAPI songjeongHyeonggok(Long songjeongHyeonggok) {
        uriBuilder.setParameter("songjeongHyeonggok", String.valueOf(songjeongHyeonggok));
        return this;
    }

    public GumiPriceInformationAPI songjeongHyeonggokLt(Long songjeongHyeonggokLt) {
        uriBuilder.setParameter("songjeongHyeonggokLt", String.valueOf(songjeongHyeonggokLt));
        return this;
    }

    public GumiPriceInformationAPI songjeongHyeonggokLte(Long songjeongHyeonggokLte) {
        uriBuilder.setParameter("songjeongHyeonggokLte", String.valueOf(songjeongHyeonggokLte));
        return this;
    }

    public GumiPriceInformationAPI songjeongHyeonggokGt(Long songjeongHyeonggokGt) {
        uriBuilder.setParameter("songjeongHyeonggokGt", String.valueOf(songjeongHyeonggokGt));
        return this;
    }

    public GumiPriceInformationAPI songjeongHyeonggokGte(Long songjeongHyeonggokGte) {
        uriBuilder.setParameter("songjeongHyeonggokGte", String.valueOf(songjeongHyeonggokGte));
        return this;
    }
    public GumiPriceInformationAPI yangpoSong(Long yangpoSong) {
        uriBuilder.setParameter("yangpoSong", String.valueOf(yangpoSong));
        return this;
    }

    public GumiPriceInformationAPI yangpoSongLt(Long yangpoSongLt) {
        uriBuilder.setParameter("yangpoSongLt", String.valueOf(yangpoSongLt));
        return this;
    }

    public GumiPriceInformationAPI yangpoSongLte(Long yangpoSongLte) {
        uriBuilder.setParameter("yangpoSongLte", String.valueOf(yangpoSongLte));
        return this;
    }

    public GumiPriceInformationAPI yangpoSongGt(Long yangpoSongGt) {
        uriBuilder.setParameter("yangpoSongGt", String.valueOf(yangpoSongGt));
        return this;
    }

    public GumiPriceInformationAPI yangpoSongGte(Long yangpoSongGte) {
        uriBuilder.setParameter("yangpoSongGte", String.valueOf(yangpoSongGte));
        return this;
    }
    public GumiPriceInformationAPI sangmoSagokImo(Long sangmoSagokImo) {
        uriBuilder.setParameter("sangmoSagokImo", String.valueOf(sangmoSagokImo));
        return this;
    }

    public GumiPriceInformationAPI sangmoSagokImoLt(Long sangmoSagokImoLt) {
        uriBuilder.setParameter("sangmoSagokImoLt", String.valueOf(sangmoSagokImoLt));
        return this;
    }

    public GumiPriceInformationAPI sangmoSagokImoLte(Long sangmoSagokImoLte) {
        uriBuilder.setParameter("sangmoSagokImoLte", String.valueOf(sangmoSagokImoLte));
        return this;
    }

    public GumiPriceInformationAPI sangmoSagokImoGt(Long sangmoSagokImoGt) {
        uriBuilder.setParameter("sangmoSagokImoGt", String.valueOf(sangmoSagokImoGt));
        return this;
    }

    public GumiPriceInformationAPI sangmoSagokImoGte(Long sangmoSagokImoGte) {
        uriBuilder.setParameter("sangmoSagokImoGte", String.valueOf(sangmoSagokImoGte));
        return this;
    }
    public GumiPriceInformationAPI indongJinmi(Long indongJinmi) {
        uriBuilder.setParameter("indongJinmi", String.valueOf(indongJinmi));
        return this;
    }

    public GumiPriceInformationAPI indongJinmiLt(Long indongJinmiLt) {
        uriBuilder.setParameter("indongJinmiLt", String.valueOf(indongJinmiLt));
        return this;
    }

    public GumiPriceInformationAPI indongJinmiLte(Long indongJinmiLte) {
        uriBuilder.setParameter("indongJinmiLte", String.valueOf(indongJinmiLte));
        return this;
    }

    public GumiPriceInformationAPI indongJinmiGt(Long indongJinmiGt) {
        uriBuilder.setParameter("indongJinmiGt", String.valueOf(indongJinmiGt));
        return this;
    }

    public GumiPriceInformationAPI indongJinmiGte(Long indongJinmiGte) {
        uriBuilder.setParameter("indongJinmiGte", String.valueOf(indongJinmiGte));
        return this;
    }
    public GumiPriceInformationAPI dataBaseDate(LocalDate dataBaseDate) {
        uriBuilder.setParameter("dataBaseDate", String.valueOf(dataBaseDate));
        return this;
    }

    public GumiPriceInformationAPI dataBaseDateAfter(LocalDate dataBaseDateAfter) {
        uriBuilder.setParameter("dataBaseDateAfter", dataBaseDateAfter.toString());
        return this;
    }

    public GumiPriceInformationAPI dataBaseDateBefore(LocalDate dataBaseDateBefore) {
        uriBuilder.setParameter("dataBaseDateBefore", dataBaseDateBefore.toString());
        return this;
    }

}