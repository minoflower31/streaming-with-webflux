package hello.streaming.entity;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

@Table("MUSIC_FILE")
@Getter
public class MusicFile {

  @Id
  private Long id;

  private String fileName;

  private String url;

  @CreatedDate
  private LocalDateTime createdAt;

  @LastModifiedDate
  private LocalDateTime updatedAt;

  @Builder
  public MusicFile(String fileName, String url) {
    this.fileName = fileName;
    this.url = url;
  }
}
