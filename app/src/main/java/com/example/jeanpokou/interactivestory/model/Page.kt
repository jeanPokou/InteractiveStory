package com.example.jeanpokou.interactivestory.model

//data class Page(var imageId:Int,var textId:Int, val Choice1: Choice,  val Choice2: Choice) {
//    val choice = Choice(1,1)
//    constructor(imageId: Int, textId: Int) : this(imageId,textId,choice){
//
//    }
//    //constructor(imageId: Int, textId: Int) : this(imageId, textId = textId)
//}

class Page {
    var imageId:Int
    var textId:Int
    var choice1:Choice?=null
    var choice2:Choice?=null
    var isFinalPage : Boolean = false

    constructor(imageId:Int,textId:Int){
        this.imageId = imageId
        this.textId = textId
        this.isFinalPage = true

    }

    constructor(imageId:Int, textId:Int,  Choice1:Choice, Choice2:Choice){
        this.imageId = imageId
        this.textId = textId
        this.choice1 = Choice1
        this.choice2 = Choice2
    }



}





