package org.softserveinc.java_be_genai_plgrnd.services;

import java.util.List;

import org.softserveinc.java_be_genai_plgrnd.dtos.business.ArticleDTO;

public interface ArticleService {
    List<ArticleDTO> findAllWithComments();
}
