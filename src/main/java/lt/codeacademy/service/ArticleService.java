package lt.codeacademy.service;

import lt.codeacademy.dto.ArticleDTO;
import lt.codeacademy.entity.Article;
import lt.codeacademy.repository.ArticleRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ThemeService themeService;
    private FileStorageService fileStorageService;

    public ArticleService(ArticleRepository articleRepository, ThemeService themeService) {
        this.articleRepository = articleRepository;
        this.themeService = themeService;
    }

    public List<Article> getAllArticles() {
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
        Article article = new Article();
        article.setDate(articleDTO.getDate());
        article.setDescription(articleDTO.getDescription());
        article.setFileName(articleDTO.getFileName());
        article.setTag(articleDTO.getTag());
        article.setTheme(themeService.findThemeById(articleDTO.getThemeId()));
        article.setText(articleDTO.getText());
        article.setTitle(articleDTO.getTitle());
        return articleRepository.save(article);
    }
}
