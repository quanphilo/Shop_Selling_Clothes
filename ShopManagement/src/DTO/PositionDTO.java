package DTO;

import java.util.Vector;

public class PositionDTO {
    private String id_positions;
    private String name;

    public PositionDTO() {
    }

    public PositionDTO(String id_positions) {
        this.id_positions = id_positions;
    }

    public PositionDTO(String id_positions, String name) {
        this.id_positions = id_positions;
        this.name = name;
    }

    public String getId_positions() {
        return id_positions;
    }

    public void setId_positions(String id_positions) {
        this.id_positions = id_positions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
