package com.example.jeanpokou.interactivestory.model

import com.example.jeanpokou.interactivestory.R


class Story internal constructor() {


    var pages = arrayOfNulls<Page>(size = 7)
    init {
        pages[0] = Page(imageId = R.drawable.page0, textId = R.string.page0, Choice1 = Choice(R.string.page0_choice1, nextPage = 1), Choice2 = Choice(R.string.page0_choice2, nextPage = 2))
        pages[1] = Page(R.drawable.page1, R.string.page1, Choice(R.string.page1_choice1, 3), Choice(R.string.page1_choice2, 4))

        pages[2] = Page(R.drawable.page2, R.string.page2, Choice(R.string.page2_choice1, 4), Choice(R.string.page2_choice2, 6))

        pages[3] = Page(R.drawable.page3, R.string.page3, Choice(R.string.page3_choice1, 4), Choice(R.string.page3_choice2, 5))

        pages[4] = Page(R.drawable.page4, R.string.page4, Choice(R.string.page4_choice1, 5), Choice(R.string.page4_choice2, 6))

        pages[5] = Page(R.drawable.page5, R.string.page5)

        pages[6] = Page(R.drawable.page6, R.string.page6)

    }


    fun getPage (pageNumber : Int) : Page? {

        if ( pageNumber > pages.size ) {
            return pages[0]
        }
        return pages[pageNumber]

    }
}