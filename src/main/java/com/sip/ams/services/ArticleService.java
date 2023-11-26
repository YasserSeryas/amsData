package com.sip.ams.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public void deleteArticle(long id) {
	     articleRepository.deleteById(id);
	}
	
	public Optional<Article> findArticleById(long id)
	{
		return articleRepository.findById(id);
	}
	
}
