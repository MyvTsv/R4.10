package edu.spring.stories.entites

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
    open lateinit var developer:Developer

    @ManyToMany
    @JoinColumn(name="tags", nullable = false)
    open val tag= mutableSetOf<Tag>()

}