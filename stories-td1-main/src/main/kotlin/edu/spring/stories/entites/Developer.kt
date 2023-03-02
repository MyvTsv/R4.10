package edu.spring.stories.entites

import jakarta.persistence.*

@Entity
@Table(name="developer")
class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id = 0

    @Column(length = 255)
    open var firstname:String?=null

    @Column(length = 255)
    open var lastname:String?=null

    @OneToMany
    @JoinColumn(name="idStory", nullable = false)
    open lateinit var story:Story

    constructor(firstname: String, lastname: String) {
        this.lastname = lastname
        this.firstname = firstname
    }
}




