package com.openmind.ezdg_api_server.gumi_price_information;

import com.openmind.ezdg_api_server.gumi_price_information.GumiPriceInformationService;
import com.openmind.ezdg_api_server.gumi_price_information.GumiPriceInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
    import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gumi_price_information")
public class GumiPriceInformationController {

    private final GumiPriceInformationService service;

    @GetMapping("")
    public List<GumiPriceInformation> search (
            @RequestParam(required = false) String itemName,
            @RequestParam(required = false) String itemNameContaining,
            @RequestParam(required = false) String specificationUnit,
            @RequestParam(required = false) String specificationUnitContaining,
            @RequestParam(required = false) Long average,
            @RequestParam(required = false) Long averageLt,
            @RequestParam(required = false) Long averageLte,
            @RequestParam(required = false) Long averageGt,
            @RequestParam(required = false) Long averageGte,
            @RequestParam(required = false) Long seonsaneup,
            @RequestParam(required = false) Long seonsaneupLt,
            @RequestParam(required = false) Long seonsaneupLte,
            @RequestParam(required = false) Long seonsaneupGt,
            @RequestParam(required = false) Long seonsaneupGte,
            @RequestParam(required = false) Long goaeup,
            @RequestParam(required = false) Long goaeupLt,
            @RequestParam(required = false) Long goaeupLte,
            @RequestParam(required = false) Long goaeupGt,
            @RequestParam(required = false) Long goaeupGte,
            @RequestParam(required = false) Long wonpyeongShinpyeong,
            @RequestParam(required = false) Long wonpyeongShinpyeongLt,
            @RequestParam(required = false) Long wonpyeongShinpyeongLte,
            @RequestParam(required = false) Long wonpyeongShinpyeongGt,
            @RequestParam(required = false) Long wonpyeongShinpyeongGte,
            @RequestParam(required = false) Long doryangSeonjuWonnam,
            @RequestParam(required = false) Long doryangSeonjuWonnamLt,
            @RequestParam(required = false) Long doryangSeonjuWonnamLte,
            @RequestParam(required = false) Long doryangSeonjuWonnamGt,
            @RequestParam(required = false) Long doryangSeonjuWonnamGte,
            @RequestParam(required = false) Long songjeongHyeonggok,
            @RequestParam(required = false) Long songjeongHyeonggokLt,
            @RequestParam(required = false) Long songjeongHyeonggokLte,
            @RequestParam(required = false) Long songjeongHyeonggokGt,
            @RequestParam(required = false) Long songjeongHyeonggokGte,
            @RequestParam(required = false) Long yangpoSong,
            @RequestParam(required = false) Long yangpoSongLt,
            @RequestParam(required = false) Long yangpoSongLte,
            @RequestParam(required = false) Long yangpoSongGt,
            @RequestParam(required = false) Long yangpoSongGte,
            @RequestParam(required = false) Long sangmoSagokImo,
            @RequestParam(required = false) Long sangmoSagokImoLt,
            @RequestParam(required = false) Long sangmoSagokImoLte,
            @RequestParam(required = false) Long sangmoSagokImoGt,
            @RequestParam(required = false) Long sangmoSagokImoGte,
            @RequestParam(required = false) Long indongJinmi,
            @RequestParam(required = false) Long indongJinmiLt,
            @RequestParam(required = false) Long indongJinmiLte,
            @RequestParam(required = false) Long indongJinmiGt,
            @RequestParam(required = false) Long indongJinmiGte,
            @RequestParam(required = false) LocalDate dataBaseDate,
            @RequestParam(required = false) LocalDate dataBaseDateAfter,
            @RequestParam(required = false) LocalDate dataBaseDateBefore,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int perPage) {

        Map <String, Object> params = new HashMap<>();

        params.put("itemName", itemName);
        params.put("itemNameContaining", itemNameContaining);
        params.put("specificationUnit", specificationUnit);
        params.put("specificationUnitContaining", specificationUnitContaining);
        params.put("average", average);
        params.put("averageLt", averageLt);
        params.put("averageLte", averageLte);
        params.put("averageGt", averageGt);
        params.put("averageGte", averageGte);
        params.put("seonsaneup", seonsaneup);
        params.put("seonsaneupLt", seonsaneupLt);
        params.put("seonsaneupLte", seonsaneupLte);
        params.put("seonsaneupGt", seonsaneupGt);
        params.put("seonsaneupGte", seonsaneupGte);
        params.put("goaeup", goaeup);
        params.put("goaeupLt", goaeupLt);
        params.put("goaeupLte", goaeupLte);
        params.put("goaeupGt", goaeupGt);
        params.put("goaeupGte", goaeupGte);
        params.put("wonpyeongShinpyeong", wonpyeongShinpyeong);
        params.put("wonpyeongShinpyeongLt", wonpyeongShinpyeongLt);
        params.put("wonpyeongShinpyeongLte", wonpyeongShinpyeongLte);
        params.put("wonpyeongShinpyeongGt", wonpyeongShinpyeongGt);
        params.put("wonpyeongShinpyeongGte", wonpyeongShinpyeongGte);
        params.put("doryangSeonjuWonnam", doryangSeonjuWonnam);
        params.put("doryangSeonjuWonnamLt", doryangSeonjuWonnamLt);
        params.put("doryangSeonjuWonnamLte", doryangSeonjuWonnamLte);
        params.put("doryangSeonjuWonnamGt", doryangSeonjuWonnamGt);
        params.put("doryangSeonjuWonnamGte", doryangSeonjuWonnamGte);
        params.put("songjeongHyeonggok", songjeongHyeonggok);
        params.put("songjeongHyeonggokLt", songjeongHyeonggokLt);
        params.put("songjeongHyeonggokLte", songjeongHyeonggokLte);
        params.put("songjeongHyeonggokGt", songjeongHyeonggokGt);
        params.put("songjeongHyeonggokGte", songjeongHyeonggokGte);
        params.put("yangpoSong", yangpoSong);
        params.put("yangpoSongLt", yangpoSongLt);
        params.put("yangpoSongLte", yangpoSongLte);
        params.put("yangpoSongGt", yangpoSongGt);
        params.put("yangpoSongGte", yangpoSongGte);
        params.put("sangmoSagokImo", sangmoSagokImo);
        params.put("sangmoSagokImoLt", sangmoSagokImoLt);
        params.put("sangmoSagokImoLte", sangmoSagokImoLte);
        params.put("sangmoSagokImoGt", sangmoSagokImoGt);
        params.put("sangmoSagokImoGte", sangmoSagokImoGte);
        params.put("indongJinmi", indongJinmi);
        params.put("indongJinmiLt", indongJinmiLt);
        params.put("indongJinmiLte", indongJinmiLte);
        params.put("indongJinmiGt", indongJinmiGt);
        params.put("indongJinmiGte", indongJinmiGte);
        params.put("dataBaseDate", dataBaseDate);
        params.put("dataBaseDateAfter", dataBaseDateAfter);
        params.put("dataBaseDateBefore", dataBaseDateBefore);

        return service.search(params, page, perPage);
    }
}
