package hello.streaming.service;

import hello.streaming.dto.MusicFileResponse;
import hello.streaming.dto.MusicFileSaveRequest;
import hello.streaming.repository.MusicFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MusicFileService {

  private final MusicFileRepository musicFileRepository;

  public Mono<Void> save(MusicFileSaveRequest musicFileSaveRequest) {
    return musicFileRepository.save(musicFileSaveRequest.toEntity())
        .then();
  }

  public Flux<MusicFileResponse> getAll() {
    return musicFileRepository.findAll()
        .map(MusicFileResponse::fromEntity);
  }

}
