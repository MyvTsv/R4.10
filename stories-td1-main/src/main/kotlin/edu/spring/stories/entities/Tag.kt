package edu.spring.stories.entities

import jakarta.persistence.*

@Entity
@Table(name="tag")
open class Tag(color: String, label: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id:Int?=null

    @Column(length = 255)
    open var color:String?=color

    @Column(length = 20)
    open var label:String?=label

    @ManyToMany
    @JoinColumn(name="stories", nullable = true)
    open var stories: MutableSet<Story> = HashSet()

}