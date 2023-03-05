package edu.spring.stories.entities

import jakarta.persistence.*

@Entity
open class Story() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id:Int = 0

    @Column(length = 255)
    open var name:String?=""

    @ManyToOne
    open var developer:Developer? = null

    @Column(nullable = true)
    @ManyToMany
    open val tags: MutableList<Tag> = mutableListOf()

    constructor(name: String):this() {
        this.name = name
        this.developer = null
    }

}