package edu.spring.stories.controllers

import edu.spring.stories.repositories.DeveloperRepository
import edu.spring.stories.repositories.StoryRepository
import edu.spring.stories.repositories.TagRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.view.RedirectView

@Controller
class MainController {

    @Autowired
    private lateinit var developerRepository: DeveloperRepository

    @Autowired
    private lateinit var storyRepository: StoryRepository

    @Autowired
    private lateinit var tagRepository: TagRepository

    @RequestMapping("/")
    fun indexAction(modelmap: ModelMap): String {
        modelmap["NombreDev"] = developerRepository.findAll().count()
        modelmap["Developpeur"] = developerRepository.findAll()
        modelmap["Story"] = storyRepository.findAll()
        modelmap["NombreStory"] = storyRepository.findAll().count()
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