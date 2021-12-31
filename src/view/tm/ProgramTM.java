package view.tm;

import javafx.scene.control.Button;

public class ProgramTM {
    String p_id;
    String name;
    String duration;
    double fee;
    Button delete;

    public ProgramTM() {
    }

    public ProgramTM(String p_id, String name, String duration, double fee) {
        this.p_id = p_id;
        this.name = name;
        this.duration = duration;
        this.fee = fee;
    }

    public ProgramTM(String p_id, String name, String duration, double fee, Button delete) {
        this.p_id = p_id;
        this.name = name;
        this.duration = duration;
        this.fee = fee;
        this.delete = delete;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }
}
