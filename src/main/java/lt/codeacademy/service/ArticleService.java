package lt.codeacademy.service;

import lt.codeacademy.dto.ArticleDTO;
import lt.codeacademy.entity.Article;
import lt.codeacademy.repository.ArticleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ThemeService themeService;
    private FileStorageService fileStorageService;

    public ArticleService(ArticleRepository articleRepository, ThemeService themeService, FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
        this.articleRepository = articleRepository;
        this.themeService = themeService;
    }

    public Page<Article> getAllArticlesByTheme(int pageNumber, Long themeId) {
        Pageable pageable = PageRequest.of(pageNumber, 3);
        if(themeId != null) {
            return articleRepository.findArticlesByThemeId(themeId, pageable);
        } else return articleRepository.findAll(pageable);
    }

    public List<Article> getAllArticles(){
        return articleRepository.findAll();
    }

    public Article getArticleById(Long id) {
        return articleRepository.getOne(id);
    }

    public Article createArticle(ArticleDTO articleDTO, MultipartFile file) {
        if (file != null) {
            articleDTO.setFileName(file.getOriginalFilename());
            fileStorageService.storeFile(file);
        }
        return ArticleDTO.fromArticleDtoToArticleEntity(articleDTO);
    }

    public Page<Article> getAllArticlesByTag(int pageNumber, String tag) {
        Pageable pageable = PageRequest.of(pageNumber, 3);
        return articleRepository.findArticlesByTag(tag, pageable);
    }
}
