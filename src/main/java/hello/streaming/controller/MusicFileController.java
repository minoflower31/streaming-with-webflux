package hello.streaming.controller;

import hello.streaming.dto.MusicFileResponse;
import hello.streaming.dto.MusicFileSaveRequest;
import hello.streaming.service.MusicFileService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class MusicFileController {

  private final MusicFileService musicFileService;

  @PostMapping("/music-file")
  public Mono<ResponseEntity<Void>> saveMusicFile(@RequestBody Mono<MusicFileSaveRequest> request) {
    return request.flatMap(musicFileService::save)
        .thenReturn(ResponseEntity.ok().build());
  }

  @GetMapping("/music-file")
  public Mono<ResponseEntity<List<MusicFileResponse>>> getAllMusicFiles() {
    return musicFileService.getAll().collectList()
        .map(ResponseEntity::ok);
  }

}
