package me.heongyukim.service;

import lombok.RequiredArgsConstructor;
import me.heongyukim.domain.Article;
import me.heongyukim.dto.AddArticleRequest;
import me.heongyukim.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BlogService {
  private final BlogRepository blogRepository;

  // 블로그 글 추가 메서드
  public Article save(AddArticleRequest request) {
      return blogRepository.save(request.toEntity());
  }

  // 블로그 글 전체 조회
  public List<Article> findAll() {
      return blogRepository.findAll();
  }
  
  // 블로그 글 하나 조회
  public Article findById(long id) {
      return blogRepository.findById(id)
              .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
  }
}
