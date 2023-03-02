package edu.spring.stories.entities

import jakarta.persistence.*

@Entity
@Table(name="developer")
class Developer {

    fun addStory(story: Story) {
        if(stories.add(story)) {
            story.developer = this
        }
    }

    fun giveUpStory(story: Story) {
        if(stories.remove(story)){
            story.developer = null
        }
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id: Int = 0

    @Column(length = 255)
    open var firstname:String?=null

    @Column(length = 255)
    open var lastname:String?=null

    @OneToMany
    @JoinColumn(name="idStory", nullable = false)
    open val stories= mutableSetOf<Story>()

    constructor(firstname: String, lastname: String) {
        this.lastname = lastname
        this.firstname = firstname
    }
}




