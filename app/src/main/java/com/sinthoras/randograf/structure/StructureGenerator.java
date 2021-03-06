package com.sinthoras.randograf.structure;

import static com.sinthoras.randograf.Random.drawRandomFromCollection;

import com.sinthoras.randograf.BlockColors;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class StructureGenerator {

    private final List<Block> structureElements = new ArrayList<>();

    public static StructureGenerator generateStructure(int size) {
        final StructureGenerator structureGenerator = new StructureGenerator();
        structureGenerator.generateStructureElements(size);
        structureGenerator.centerStructure();
        structureGenerator.orientStructure();
        return structureGenerator;
    }

    public Structure withColor(BlockColors color) {
        return new Structure(structureElements, color);
    }

    private void generateStructureElements(int size) {
        addRootElement();
        for(int i = 0; i < size; i++) {
            addRandomNeighbor();
        }
        removeRandomElement();
    }

    private void addRootElement() {
        structureElements.add(new Block(0, 0));
    }

    private void addRandomNeighbor() {
        final Block selectedNeighbor = drawRandomFromCollection(getAvailableNeighborsToAdd());
        structureElements.add(selectedNeighbor);
    }

    private Set<Block> getAvailableNeighborsToAdd() {
        final Set<Block> neighbors = getUniqueNeighbors();
        neighbors.removeAll(structureElements);
        return neighbors;
    }

    private Set<Block> getUniqueNeighbors() {
        return structureElements.stream()
                .map(Block::getNeighbors)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }

    private void removeRandomElement() {
        structureElements.remove(drawRandomFromCollection(structureElements));
    }

    private void centerStructure() {
        Block center = getStructureCenter();
        offsetStructureElementsByCenter(center);
    }

    private Block getStructureCenter() {
        final double minX = minCoordinate(Block::getX);
        final double maxX = maxCoordinate(Block::getX);
        final double minY = minCoordinate(Block::getY);
        final double maxY = maxCoordinate(Block::getY);
        return new Block((maxX + minX) / 2, (maxY + minY) / 2);
    }

    private double minCoordinate(ToDoubleFunction<Block> accessor) {
        return structureElements.stream().mapToDouble(accessor).min().orElse(0);
    }

    private double maxCoordinate(ToDoubleFunction<Block> accessor) {
        return structureElements.stream().mapToDouble(accessor).max().orElse(0);
    }

    private void offsetStructureElementsByCenter(Block center) {
        structureElements.forEach(element -> element.subtract(center));
    }

    private void orientStructure() {
        // structure is already centered, get orientation by comparing max in both directions
        final double maxX = maxCoordinate(Block::getX);
        final double maxY = maxCoordinate(Block::getY);
        if (maxY > maxX) {
            swapXY();
        }
    }

    private void swapXY() {
        structureElements.forEach(Block::swapXY);
    }
}
