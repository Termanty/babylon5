package ohtumini.controller;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import javax.validation.Valid;
import ohtumini.domain.Article;
import ohtumini.domain.Book;
import ohtumini.domain.Inproceedings;
import ohtumini.domain.Reference;
import ohtumini.repository.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ohtumini.Init;
import ohtumini.domain.IdGenerator;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
@RequestMapping("references")
public class ReferenceController {

//    Init init = new Init();
    @Autowired
    ReferenceRepository referenceRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("amount", referenceRepository.count());
        model.addAttribute("references", referenceRepository.findAll());
        return "/WEB-INF/views/references/index.jsp";
    }

    @RequestMapping("/newReference")
    public String newReferencePage() {
        return "/WEB-INF/views/references/newReference.jsp";
    }

    @RequestMapping("/newArticle")
    public String newArticle() {
        return "/WEB-INF/views/references/newArticle.jsp";
    }

    @RequestMapping("/newBook")
    public String newBook() {
        return "/WEB-INF/views/references/newBook.jsp";
    }

    @RequestMapping("/newInproceeding")
    public String newInproceeding() {
        return "/WEB-INF/views/references/newInproceeding.jsp";
    }

    @RequestMapping(value = "/newArticle", method = RequestMethod.POST)
    @Transactional
    public String createArticle(
            @RequestParam(required = true) String title,
            @RequestParam(required = true) String author,
            @RequestParam(required = true) String journal,
            @RequestParam(required = true) String pubYear,
            @RequestParam(required = true) String volume,
            @RequestParam(required = false) String number,
            @RequestParam(required = false) String pages,
            @RequestParam(required = false) String pubMonth,
            @RequestParam(required = false) String note,
            @RequestParam(required = false) String pubKey) {

        Article newReference = new Article();
        newReference.setTitle(title);
        newReference.setAuthor(author);
        newReference.setJournal(journal);
        newReference.setPubYear(pubYear);
        newReference.setVolume(volume);
        newReference.setNumber(number);
        newReference.setPages(pages);
        newReference.setPubMonth(pubMonth);
        newReference.setNote(note);
        newReference.setPubKey(pubKey);

        referenceRepository.save(newReference);
        return "redirect:/references/";
    }

    @RequestMapping(value = "/newBook", method = RequestMethod.POST)
    @Transactional
    public String createBook(
            @RequestParam(required = true) String title,
            @RequestParam(required = true) String author,
            @RequestParam(required = true) String publisher,
            @RequestParam(required = true) String pubYear,
            @RequestParam(required = false) String volume,
            @RequestParam(required = false) String series,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String edition,
            @RequestParam(required = false) String pubMonth,
            @RequestParam(required = false) String note,
            @RequestParam(required = false) String pubKey) {

        Book newReference = new Book();
        newReference.setTitle(title);
        newReference.setAuthor(author);
        newReference.setPublisher(publisher);
        newReference.setPubYear(pubYear);
        newReference.setVolume(volume);
        newReference.setSeries(series);
        newReference.setAddress(address);
        newReference.setEdition(edition);
        newReference.setPubMonth(pubMonth);
        newReference.setNote(note);
        newReference.setPubKey(pubKey);

        referenceRepository.save(newReference);
        return "redirect:/references/";
    }

    @RequestMapping(value = "/newInproceeding", method = RequestMethod.POST)
    @Transactional
    public String createInproceedings(
            @RequestParam(required = true) String title,
            @RequestParam(required = true) String author,
            @RequestParam(required = true) String bookTitle,
            @RequestParam(required = true) String pubYear,
            @RequestParam(required = false) String volume,
            @RequestParam(required = false) String publisher,
            @RequestParam(required = false) String editor,
            @RequestParam(required = false) String organization,
            @RequestParam(required = false) String pages,
            @RequestParam(required = false) String series,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String pubMonth,
            @RequestParam(required = false) String note,
            @RequestParam(required = false) String pubKey) {

        Inproceedings newReference = new Inproceedings();
        newReference.setTitle(title);
        newReference.setAuthor(author);
        newReference.setBookTitle(bookTitle);
        newReference.setPublisher(publisher);
        newReference.setPubYear(pubYear);
        newReference.setVolume(volume);
        newReference.setSeries(series);
        newReference.setAddress(address);
        newReference.setEditor(editor);
        newReference.setOrganisation(organization);
        newReference.setPages(pages);
        newReference.setPubMonth(pubMonth);
        newReference.setNote(note);
        newReference.setPubKey(pubKey);

        referenceRepository.save(newReference);
        return "redirect:/references/";
    }

    @RequestMapping(value = "{referenceID}", method = RequestMethod.GET)
    public String show(Model model, @PathVariable(value = "referenceID") Long id) {
        model.addAttribute("reference", referenceRepository.findOne(id));
        return "/WEB-INF/views/references/show.jsp";
    }

    @RequestMapping(value = "{referenceID}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "referenceID") Long id) {
        referenceRepository.delete(id);
        return "redirect:/references/";
    }

    @RequestMapping(value = "bibtex", method = RequestMethod.GET)
    public String createBibtex(Model model) {
        List<Reference> references = referenceRepository.findAll();
        List<String> referencesInBibtex = new ArrayList<>();

        for (Reference reference : references) {
            referencesInBibtex.add(getBibtexFormat(reference));
        }
        model.addAttribute("references", referencesInBibtex);

        return "/WEB-INF/views/references/bibtex.jsp";
    }

    private String getBibtexFormat(Reference ref) {
        String type = ref.getReferenceType();
        if (type.equals("ARTICLE")) {
            Article article = (Article) ref;
            return article.toBibtex();
        }
        if (type.equals("BOOK")) {
            Book book = (Book) ref;
            return book.toBibtex();
        }
        if (type.equals("INPROCEEDINGS")) {
            Inproceedings inproceedings = (Inproceedings) ref;
            return inproceedings.toBibtex();
        }
        return "";
    }

    /**
     * Checks if given id key is unique and generates new if necessary.
     * 
     * @param pubKey
     * @param author
     * @param year
     * @return new unique key if given key was empty or not unique, otherwise
     * returns given key unchanged
     */
    private String checkReferenceId(String pubKey, String author, String year) {
        IdGenerator ig = new IdGenerator(referenceRepository);

        if (pubKey == null
                || pubKey.isEmpty()
                || !ig.checkUniqueness(pubKey)) {
            return ig.generateId(author, year);
        }

        return pubKey;
    }

}
