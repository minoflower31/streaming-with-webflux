package hello.streaming.dto;

import hello.streaming.entity.MusicFile;
import lombok.Getter;

@Getter
public class MusicFileSaveRequest {

  private String fileName;
  private String url;

  public MusicFile toEntity() {
    return MusicFile.builder()
        .fileName(this.fileName)
        .url(this.url)
        .build();
  }
}
