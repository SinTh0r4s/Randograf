package com.sinthoras.randograf.cards

import android.os.Bundle
import android.view.View
import com.sinthoras.randograf.BlockColors
import com.sinthoras.randograf.MainActivity
import com.sinthoras.randograf.structure.StructureGenerator
import com.sinthoras.randograf.R
import com.sinthoras.randograf.structure.StructureView

class CardJoker : Card(R.layout.fragment_card_joker) {
    private val structure = StructureGenerator.generateStructure(1).withColor(BlockColors.ALL)

    override fun getDuration(): Int {
        return 0
    }

    override fun getTitle(): String {
        return MainActivity.getResourceString(R.string.card_title_joker)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getView()?.findViewById<StructureView>(R.id.structureView)?.setStructure(structure)
    }
}
