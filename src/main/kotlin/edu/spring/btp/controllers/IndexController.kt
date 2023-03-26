package edu.spring.btp.controllers

import edu.spring.btp.entities.Domain
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class IndexController {

    @Autowired
    lateinit var userRepository: edu.spring.btp.repositories.UserRepository

    @Autowired
    lateinit var domainRepository: edu.spring.btp.repositories.DomainRepository

    @Autowired
    lateinit var complaintRepository: edu.spring.btp.repositories.ComplaintRepository

    @Autowired
    lateinit var providerRepository: edu.spring.btp.repositories.ProviderRepository

    @RequestMapping("")
    fun showIndex(modelMap: ModelMap): String {
        val domainName = "Root"
        val rootDomain: Domain = domainRepository.findByName(domainName)
        modelMap["domain"] = rootDomain
        modelMap["name"] = domainName
        return "index"
    }

    @RequestMapping("/domain/{name}")
    fun showDomain(@PathVariable name: String, modelMap: ModelMap): String {
        val domain: Domain = domainRepository.findByName(name)
        modelMap["domain"] = domain
        modelMap["name"] = name
        return "domain"
    }

    @GetMapping("/complaint/{domain}")
    fun showComplaint(@PathVariable domain: String, modelMap: ModelMap): String {
        modelMap["name"] = domain
        modelMap["domain"] = domainRepository.findByName(domain)
        modelMap["complaints"] = domainRepository.findByName(domain).complaints
        return "complaint"
    }

    @GetMapping("/complaint/{domain}/new")
    fun newComplaint(@PathVariable domain: String, modelMap: ModelMap): String {
        modelMap["name"] = domain
        modelMap["domain"] = domainRepository.findByName(domain)
        modelMap["complaints"] = domainRepository.findByName(domain).complaints
        return "forms/complaint"
    }
}