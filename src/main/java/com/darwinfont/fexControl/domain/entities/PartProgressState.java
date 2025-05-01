package com.darwinfont.fexControl.domain.entities;

import lombok.Getter;

import java.util.List;

@Getter
public enum PartProgressState {
    CUTTING("Cutting"),
    BENDING("Bending"),
    WELDING("Welding"),
    PAINTING("Painting"),
    PACKAGING("Packaging"),
    SHIPPING("Shipping");

    private final String label;

    PartProgressState(String label) {
        this.label = label;
    }

    // Permite obtener un estado desde su label
    public static PartProgressState fromLabel(String label) {
        for (PartProgressState state : values()) {
            if (state.label.equalsIgnoreCase(label)) {
                return state;
            }
        }
        throw new IllegalArgumentException("No enum constant with label: " + label);
    }

    // Define si el estado es considerado final
    public boolean isFinalState() {
        return this == PACKAGING || this == SHIPPING;
    }

    // Opcional: estados ordenados por flujo
    public static List<PartProgressState> orderedFlow() {
        return List.of(CUTTING, BENDING, WELDING, PAINTING, PACKAGING, SHIPPING);
    }
}
