package edu.spring.stories.entities

import jakarta.persistence.*

@Entity
class Developer() {

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

    @PreRemove
    fun preRemove() {
        stories.removeAll(stories)
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id: Int = 0

    @Column(length = 255)
    open var firstname:String=""

    @Column(length = 255)
    open var lastname:String=""

    @Column(nullable = true)
    @OneToMany(cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    open var stories: MutableSet<Story> = mutableSetOf()

    constructor(firstname: String, lastname: String) : this() {
        this.lastname = lastname
        this.firstname = firstname
    }
}




