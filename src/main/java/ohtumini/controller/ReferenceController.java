package ohtumini.controller;

import javax.transaction.Transactional;
import ohtumini.domain.ArticleReference;
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
    
    
    @RequestMapping("/new")
    public String newPage() {
        return "/WEB-INF/views/references/new.jsp";
    }
    
    
    @RequestMapping(method = RequestMethod.POST)
    @Transactional
    public String create(
            @RequestParam String title, 
            @RequestParam String author, 
            @RequestParam String journal, 
            @RequestParam String year, 
            @RequestParam String volume, 
            @RequestParam String number, 
            @RequestParam String pages, 
            @RequestParam String month, 
            @RequestParam String note, 
            @RequestParam String key) {
        
        ArticleReference newReference = new ArticleReference();
        newReference.setName(title);
        newReference.setAuthor(author);
        newReference.setJournal(journal);
        newReference.setYear(year);
        newReference.setVolume(volume);
        newReference.setNumber(number);
        newReference.setPages(pages);
        newReference.setMonth(month);
        newReference.setNote(note);
        newReference.setKey(key);
                
        
        
      
       referenceRepository.save(newReference);
        return "redirect:/references";
    }
    
    
    @RequestMapping(value = "{referenceID}", method = RequestMethod.GET)
    public String show(Model model, @PathVariable(value = "referenceID") Long id) {
        model.addAttribute("reference", referenceRepository.findOne(id));
        return "/WEB-INF/views/references/show.jsp";
    }
    
}
