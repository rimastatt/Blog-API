package lt.codeacademy.service;

import lt.codeacademy.entity.Article;
import lt.codeacademy.entity.Trip;
import lt.codeacademy.repository.ArticleRepository;
import lt.codeacademy.repository.TripRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ArticleService {

    private final TripRepository tripRepository;
    private final ArticleRepository articleRepository;
    private final ThemeService themeService;
    private FileStorageService fileStorageService;

    public ArticleService(ArticleRepository articleRepository, ThemeService themeService, FileStorageService fileStorageService, TripRepository tripRepository) {
        this.fileStorageService = fileStorageService;
        this.tripRepository = tripRepository;
        this.articleRepository = articleRepository;
        this.themeService = themeService;
    }

    public Page<Article> getAllArticles(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return articleRepository.findAll(pageable);
    }

    public Page<Article> getAllArticlesByTheme(int pageNumber, Long themeId, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return articleRepository.findArticlesByThemeId(themeId, pageable);
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(Long id) {
        return articleRepository.getOne(id);
    }


    public void deleteArticle(Long id) {
        List<Trip> tripList = tripRepository.getTripsByArticleId(id);
        if (tripList != null) {
            tripList.forEach(trip -> trip.setArticle(null));
        }
        articleRepository.deleteById(id);
    }

    @Transactional
    public Article createArticle(Article article, MultipartFile file) {
        if (file != null) {
            article.setFileName(file.getOriginalFilename());
            fileStorageService.storeFile(file);
        }
        return articleRepository.save(article);
    }

    public Page<Article> getAllArticlesByTag(int pageNumber, String tag, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return articleRepository.findArticlesByTag(tag, pageable);
    }
}
