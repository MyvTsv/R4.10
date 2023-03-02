package edu.spring.stories.entities

import jakarta.persistence.*

@Entity
@Table(name="story")
class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id:Int?=null

    @Column(length = 255)
    open var name:String?=null

    @ManyToOne
    @JoinColumn(name="idDeveloper", nullable = false)
    open var developer:Developer? = null

    @ManyToMany
    @JoinColumn(name="tags", nullable = false)
    open val tags= mutableSetOf<Tag>()

    constructor(name: String) {
        this.name = name
    }

}