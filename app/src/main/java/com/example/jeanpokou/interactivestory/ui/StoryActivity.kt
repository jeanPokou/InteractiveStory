package com.example.jeanpokou.interactivestory.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.jeanpokou.interactivestory.R
import com.example.jeanpokou.interactivestory.model.Story
import kotlinx.android.synthetic.main.activity_story.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import java.util.*


class StoryActivity : AppCompatActivity() , AnkoLogger {

    private val log = AnkoLogger<StoryActivity>()
    var story = Story()
    var name : String = ""
    private val pageStack = Stack<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)

        val  intent : Intent = intent
        name = intent.getStringExtra(R.string.key_name.toString())

        name?.let {
            log.info(name)
        }

        loadPage(0)


    }

    private fun  loadPage(pageNumber:  Int) {


        pageStack.push(pageNumber);

        val page = story.getPage(pageNumber)
        val drawable = page?.imageId?.let { resources.getDrawable(it) }
        storyImageView.setImageDrawable(drawable)
        var pageText :String = page?.textId?.let { getString(it) } as String
        pageText = String.format(pageText,name )
        storyTextView.text = pageText

        if(!page.isFinalPage) {
            choice1Button.visibility = View.VISIBLE
            choice1Button.text = getString( page.choice1!!.textId)
            choice1Button.setOnClickListener{
                val nextPage  : Int = page.choice1!!.nextPage
                loadPage(nextPage)

            }
            choice2Button.text = getString(page.choice2!!.textId)
            choice2Button.setOnClickListener{
                val nextPage  : Int = page.choice2!!.nextPage
                loadPage(nextPage)

            }

        } else {
            choice1Button.visibility = View.INVISIBLE
            choice2Button.text = getString(R.string.play_again)
            choice2Button.setOnClickListener{
                loadPage(0)
            }
        }

    }

    override fun onBackPressed() {
        pageStack.pop()
        if(pageStack.isEmpty()) {
            super.onBackPressed()
        } else {
            loadPage(pageStack.pop())
        }
    }
}

