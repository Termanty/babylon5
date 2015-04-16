package ohtumini.controller;

import java.util.HashMap;
import javax.transaction.Transactional;
import ohtumini.domain.Article;
import ohtumini.repository.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// using Rails convention for /resources - path mapping
@Controller
@RequestMapping("references")
public class ReferenceController {

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

    @RequestMapping(method = RequestMethod.POST)
    @Transactional
    public String create(
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam String journal,
            @RequestParam String pubYear,
            @RequestParam String volume,
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

    @RequestMapping(value = "{referenceID}", method = RequestMethod.GET)
    public String show(Model model, @PathVariable(value = "referenceID") Long id) {
        model.addAttribute("reference", referenceRepository.findOne(id));
        return "/WEB-INF/views/references/show.jsp";
    }

}
