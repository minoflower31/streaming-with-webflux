package hello.streaming.dto;

import hello.streaming.entity.MusicFile;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MusicFileResponse {

  private Long id;
  private String fileName;
  private String url;
  private LocalDateTime createdAt;

  public static MusicFileResponse fromEntity(MusicFile musicFile) {
    return MusicFileResponse.builder()
        .id(musicFile.getId())
        .fileName(musicFile.getFileName())
        .url(musicFile.getUrl())
        .createdAt(musicFile.getCreatedAt())
        .build();
  }

}
