package ro.cti.ssa.aossi.springer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cti.ssa.aossi.springer.framework.CrawlerService;
import ro.cti.ssa.aossi.springercrawler.dao.*;
import ro.cti.ssa.aossi.springercrawler.model.*;
import ro.cti.ssa.aossi.springercrawler.wrapper.SpringerCrawler;

import java.util.List;

/**
 * @author adrian.zamfirescu
 * @since 1/16/2014
 */
@Service
public class CrawlerServiceImpl implements CrawlerService{

    private SpringerCrawler springerCrawler;
    private ArticleRepository articleRepository;
    private AuthorRepository authorRepository;
    private EditorRepository editorRepository;
    private AuthorAffiliationRepository authorAffiliationRepository;
    private EditorAffiliationRepository editorAffiliationRepository;
    private AdditionalLinkRepository additionalLinkRepository;
    private EBookPackageRepository eBookPackageRepository;
    private IndustrySectorRepository industrySectorRepository;
    private KeywordRepository keywordRepository;
    private PublicationRepository publicationRepository;
    private TopicRepository topicRepository;

    @Autowired
    public CrawlerServiceImpl(SpringerCrawler springerCrawler,
                              AuthorRepository authorRepository,
                              ArticleRepository articleRepository,
                              EditorRepository editorRepository,
                              AuthorAffiliationRepository authorAffiliationRepository,
                              EditorAffiliationRepository editorAffiliationRepository,
                              AdditionalLinkRepository additionalLinkRepository,
                              EBookPackageRepository eBookPackageRepository,
                              IndustrySectorRepository industrySectorRepository,
                              KeywordRepository keywordRepository,
                              PublicationRepository publicationRepository,
                              TopicRepository topicRepository){

        this.springerCrawler = springerCrawler;
        this.articleRepository = articleRepository;
        this.authorRepository = authorRepository;
        this.editorRepository = editorRepository;
        this.authorAffiliationRepository = authorAffiliationRepository;
        this.editorAffiliationRepository = editorAffiliationRepository;
        this.additionalLinkRepository = additionalLinkRepository;
        this.eBookPackageRepository = eBookPackageRepository;
        this.industrySectorRepository = industrySectorRepository;
        this.keywordRepository = keywordRepository;
        this.publicationRepository = publicationRepository;
        this.topicRepository = topicRepository;
    }


    @Override
    public Integer crawlArticles(String authorName) {

        List<Article> articles = springerCrawler.getArticles(authorName);

        if (articles==null)
            return null;

        for (Article article : articles){

            resolveAuthors(article);
            resolveEditors(article);
            resolveAuthorAffiliations(article);
            resolveEditorAffiliations(article);
            resolveAdditionalLinks(article);
            resolveEBookPackage(article);
            resolveIndustrySectors(article);
            resolveKeywords(article);
            resolvePublication(article);
            resolveTopics(article);

            articleRepository.save(article);

        }

        return articles.size();
    }

    private void resolveAuthors(Article article){

        List<Author> authors = article.getAuthors();
        for (int index=0; index<authors.size(); index++){

            Author foundAuthor = authorRepository.findByName(authors.get(index).getName());
            if (foundAuthor==null)
                authorRepository.save(authors.get(index));
            else
                authors.set(index,foundAuthor);

        }

    }

    private void resolveEditors(Article article){

        List<Editor> editors = article.getEditors();
        for (int index=0; index<editors.size(); index++){

            Editor foundEditor = editorRepository.findByName(editors.get(index).getName());
            if (foundEditor==null)
                editorRepository.save(editors.get(index));
            else
                editors.set(index,foundEditor);

        }

    }

    private void resolveAuthorAffiliations(Article article){

        List<AuthorAffiliation> authorAffiliations = article.getAuthorAffiliations();
        for (int index=0; index<authorAffiliations.size(); index++){

            AuthorAffiliation foundAuthorAffiliation = authorAffiliationRepository.findByName(authorAffiliations.get(index).getName());
            if (foundAuthorAffiliation==null)
                authorAffiliationRepository.save(authorAffiliations.get(index));
            else
                authorAffiliations.set(index,foundAuthorAffiliation);

        }

    }

    private void resolveEditorAffiliations(Article article){

        List<EditorAffiliation> editorAffiliations = article.getEditorAffiliations();
        for (int index=0; index<editorAffiliations.size(); index++){

            EditorAffiliation foundEditorAffiliation = editorAffiliationRepository.findByName(editorAffiliations.get(index).getName());
            if (foundEditorAffiliation==null)
                editorAffiliationRepository.save(editorAffiliations.get(index));
            else
                editorAffiliations.set(index,foundEditorAffiliation);

        }

    }

    private void resolveAdditionalLinks(Article article){

        List<AdditionalLink> additionalLinks = article.getAdditionalLinks();
        for (int index=0; index<additionalLinks.size(); index++){

            AdditionalLink foundAdditionalLink = additionalLinkRepository.findByLinkName(additionalLinks.get(index).getLinkName());
            if (foundAdditionalLink==null)
                additionalLinkRepository.save(additionalLinks.get(index));
            else
                additionalLinks.set(index,foundAdditionalLink);

        }

    }

    private void resolveEBookPackage(Article article){

        List<EBookPackage> eBookPackages = article.geteBookPackages();
        for (int index=0; index<eBookPackages.size(); index++){

            EBookPackage foundEBookPackage = eBookPackageRepository.findByeBookPackageName(eBookPackages.get(index).geteBookPackageName());
            if (foundEBookPackage==null)
                eBookPackageRepository.save(eBookPackages.get(index));
            else
                eBookPackages.set(index,foundEBookPackage);

        }

    }

    private void resolveIndustrySectors(Article article){

        List<IndustrySector> industrySectors = article.getIndustrySectors();
        for (int index=0; index<industrySectors.size(); index++){

            IndustrySector foundIndustrySector = industrySectorRepository.findByIndustrySectorName(industrySectors.get(index).getIndustrySectorName());
            if (foundIndustrySector==null)
                industrySectorRepository.save(industrySectors.get(index));
            else
                industrySectors.set(index,foundIndustrySector);

        }

    }

    private void resolveKeywords(Article article){

        List<Keyword> keywords = article.getKeywords();
        for (int index=0; index<keywords.size(); index++){

            Keyword foundKeyword = keywordRepository.findByName(keywords.get(index).getName());
            if (foundKeyword==null)
                keywordRepository.save(keywords.get(index));
            else
                keywords.set(index,foundKeyword);

        }

    }

    private void resolvePublication(Article article){

            Publication foundPublication = publicationRepository.findByPublicationTitle(article.getPublication().getPublicationTitle());
            if (foundPublication==null)
                publicationRepository.save(article.getPublication());
            else
                article.setPublication(foundPublication);

    }


    private void resolveTopics(Article article){

        List<Topic> topics = article.getTopics();
        for (int index=0; index<topics.size(); index++){

            Topic foundTopic = topicRepository.findByTopicName(topics.get(index).getTopicName());
            if (foundTopic==null)
                topicRepository.save(topics.get(index));
            else
                topics.set(index,foundTopic);

        }

    }
}
