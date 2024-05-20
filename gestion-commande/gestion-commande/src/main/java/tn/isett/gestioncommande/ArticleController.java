package tn.isett.gestioncommande;

import tn.isett.gestioncommande.Article;
import tn.isett.gestioncommande.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

  @Autowired
  private ArticleRepository articleRepository;

  @GetMapping
  public List<Article> getAllArticles() {
    return articleRepository.findAll();
  }

  @PostMapping
  public Article createArticle(@RequestBody Article article) {
    return articleRepository.save(article);
  }

  @PutMapping("/{id}")
  public Article updateArticle(@PathVariable Long id, @RequestBody Article articleDetails) {
    Article article = articleRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Article non trouvé avec l'identifiant : " + id));

    // Mettez à jour les détails de l'article
    article.setCodeart(articleDetails.getCodeart());
    article.setDesart(articleDetails.getDesart());
    article.setCouleur(articleDetails.getCouleur());
    article.setPuart(articleDetails.getPuart());
    article.setQtestock(articleDetails.getQtestock());

    return articleRepository.save(article);
  }

  @DeleteMapping("/{id}")
  public void deleteArticle(@PathVariable Long id) {
    Article article = articleRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Article non trouvé avec l'identifiant : " + id));

    articleRepository.delete(article);
  }
}


