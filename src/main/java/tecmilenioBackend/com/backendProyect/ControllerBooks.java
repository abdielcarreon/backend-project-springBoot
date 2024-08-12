package tecmilenioBackend.com.backendProyect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerBooks {

    @Autowired
    private Repository_Books repo;

    // http://localhost:8080/pageBookByID_GET?id=1
    @GetMapping("/pageBookByID_GET")
    public void myPageGET(@RequestParam(name="id", required=false, defaultValue = "0") int id, Model model){
        BookModel bookmodel = repo.searchByID(id);
        if(bookmodel == null) {
            model.addAttribute("bookmodel", null);
            model.addAttribute("id", id);
            return;
        }
        model.addAttribute("bookmodel", bookmodel);
    }

    @GetMapping("/formPageWithPOST")
    public void formWithPOST(Model model) {
        model.addAttribute("bookmodel", new BookModel());
    }

    @PostMapping("/POSTRequestResult")
    public String result(@ModelAttribute BookModel bookmodel, Model model){
        BookModel insbookmodel = repo.insert(bookmodel);
        model.addAttribute("bookmodel", insbookmodel);
        return "myPagePOSTResult";
    }

}

