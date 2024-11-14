package com.openmind.ezdg.algolia;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class AlgoliaController {

    private final AlgoliaService algoliaService;

    @PostMapping("/file")
    public ResponseEntity<?> addObjectTest(@RequestBody AlgoliaSearchFileDto request) {
        algoliaService.addEzdgGuideSearchObject(request);
        return ResponseEntity.ok().body("ok");
    }

    @PostMapping("/api")
    public ResponseEntity<?> addObjectTest(@RequestBody AlgoliaSearchApiDto request) {
        algoliaService.addEzdgGuideSearchObject(request);
        return ResponseEntity.ok().body("ok");
    }
}
