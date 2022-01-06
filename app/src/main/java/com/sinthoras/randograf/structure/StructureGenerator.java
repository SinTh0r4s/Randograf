package com.sinthoras.randograf.structure;

import com.sinthoras.randograf.Colors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class StructureGenerator {

    private final List<Coordinate> structureElements = new ArrayList<>();

    private final Random random = new Random();

    public static StructureGenerator generateStructure(int size) {
        final StructureGenerator structureGenerator = new StructureGenerator();
        structureGenerator.generateStructureElements(size);
        structureGenerator.centerStructure();
        return structureGenerator;
    }

    public Structure withColor(Colors color) {
        return new Structure(structureElements, color);
    }

    private void generateStructureElements(int size) {
        addRootElement();
        for(int i = 0; i < size + 1; i++) {
            addRandomNeighbor();
        }
        removeRandomElement();
    }

    private void addRootElement() {
        structureElements.add(new Coordinate(0, 0));
    }

    private void addRandomNeighbor() {
        final List<Coordinate> neighbors = new ArrayList<>(getNewNeighbors());
        final Coordinate selectedNeighbor = neighbors.get(random.nextInt(neighbors.size()));
        structureElements.add(selectedNeighbor);
    }

    private Set<Coordinate> getNewNeighbors() {
        final Set<Coordinate> neighbors = getUniqueNeighbors();
        neighbors.removeAll(structureElements);
        return neighbors;
    }

    private Set<Coordinate> getUniqueNeighbors() {
        return structureElements.stream()
                .map(Coordinate::getNeighbors)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }

    private void removeRandomElement() {
        structureElements.remove(random.nextInt(structureElements.size()));
    }

    private void centerStructure() {
        Coordinate center = getStructureCenter();
        offsetStructureElementsByCenter(center);
    }

    private Coordinate getStructureCenter() {
        return new Coordinate(sumCoordinate(Coordinate::getX), sumCoordinate(Coordinate::getY));
    }

    private double sumCoordinate(ToDoubleFunction<Coordinate> accessor) {
        return structureElements.stream().mapToDouble(accessor).sum();
    }

    private void offsetStructureElementsByCenter(Coordinate center) {
        structureElements.forEach(element -> element.subtract(center));
    }
}
