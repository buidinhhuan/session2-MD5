package ra.bt1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.bt1.model.entity.blogs;
import ra.bt1.model.service.IBlogService;

@Controller
@RequestMapping({"/"})
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping
    public String home(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "home";
    }
    @GetMapping("/add")
    public ModelAndView add() {
        return new ModelAndView("add", "blog", new blogs());
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        return new ModelAndView("edit", "blog", blogService.findById(id));
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        blogService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String handleAdd(@ModelAttribute blogs blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @PostMapping("/edit")
    public String handleEdit(@ModelAttribute blogs blog) {
        blogService.save(blog);
        return "redirect:/";
    }
}
