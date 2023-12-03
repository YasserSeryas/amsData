package com.sip.ams.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.ams.controllers.ArticleController;
import com.sip.ams.entities.Article;
import com.sip.ams.repositories.ArticleRepository;

@Service
public class ArticleService {

	@Autowired  // Spring va se charger de créer un objet qui implémente cette interface
	ArticleRepository articleRepository ;
	
	
	public Article saveArticle(Article article)
	{
		return articleRepository.save(article);  // sauvegarder dans la base
		
	}
	
	public List<Article> listArticle()
	{
		return (List<Article>) articleRepository.findAll();	 // lister tous les articles de la base
	}

	public void deleteArticle(long id)  {
		// TO DO 1 : Delete de l'image
	    Optional<Article> oa =  findArticleById(id);
	    if(oa.isPresent())
	    {
	    	Article article = oa.get();
	    	String urlImage = article.getPicture();
	    	if(urlImage!=null) {
	    	Path path = Paths.get(ArticleController.uploadDirectory,urlImage);
	        
	    	try {
				Files.deleteIfExists(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	}
	    }
	     
	     // TO DO 2 :Delete de l'article de la base 
		articleRepository.deleteById(id);
	}
	
	public Optional<Article> findArticleById(long id)
	{
		return articleRepository.findById(id);
	}
	
}
