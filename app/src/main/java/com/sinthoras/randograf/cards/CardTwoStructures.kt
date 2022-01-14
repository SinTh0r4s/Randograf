package com.sinthoras.randograf.cards

import android.os.Bundle
import android.view.View
import com.sinthoras.randograf.BlockColors
import com.sinthoras.randograf.MainActivity
import com.sinthoras.randograf.R
import com.sinthoras.randograf.Random
import com.sinthoras.randograf.structure.Structure
import com.sinthoras.randograf.structure.StructureGenerator
import com.sinthoras.randograf.structure.StructureView

abstract class CardTwoStructures protected constructor(
    colorA: BlockColors?,
    generator: StructureBGenerator
) : Card(R.layout.fragment_card_two_structures) {

    interface StructureBGenerator {
        fun generateStructureB(structureA: Structure?): Structure
    }

    private val structureA: Structure
    private val structureB: Structure


    override fun getTitle(): String {
        return MainActivity.getResourceString(R.string.card_title_two_options)
    }

    init {
        structureA = StructureGenerator.generateStructure(Random.getRandomFromTo(4, 5)).withColor(colorA)
        structureB = generator.generateStructureB(structureA)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getView()?.findViewById<StructureView>(R.id.structureViewA)?.setStructure(structureA)
        getView()?.findViewById<StructureView>(R.id.structureViewB)?.setStructure(structureB)
    }
}
