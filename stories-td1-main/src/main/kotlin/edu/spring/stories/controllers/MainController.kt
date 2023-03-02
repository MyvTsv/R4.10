package edu.spring.stories.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.view.RedirectView

@Controller
class MainController {

    @RequestMapping("/")
    fun indexAction(): String {
        return "index"
    }

    @PostMapping("/developer/add")
    fun addDeveloper(): RedirectView {
        return RedirectView("/")
    }

    @PostMapping("/developer/{id}/story")
    fun addStory(): RedirectView {
        return RedirectView("/")
    }

    @GetMapping("/developer/{id}/giveup")
    fun removeStoryForDeveloper(): RedirectView {
        return RedirectView("/")
    }

    @GetMapping("/developer/{id}/delete")
    fun removeDeveloper(): RedirectView {
        return RedirectView("/")
    }

    @PostMapping("/developer/{id}/action")
    fun removeStory(): RedirectView {
        return RedirectView("/")
    }
}