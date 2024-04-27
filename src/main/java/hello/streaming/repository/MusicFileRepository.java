package hello.streaming.repository;

import hello.streaming.entity.MusicFile;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MusicFileRepository extends ReactiveCrudRepository<MusicFile, Long> {

  
}
