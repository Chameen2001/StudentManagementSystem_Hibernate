package dto;

public class ProgramDTO {
    String p_id;
    String name;
    String Duration;
    double fee;

    public ProgramDTO() {
    }

    public ProgramDTO(String p_id, String name, String duration, double fee) {
        this.p_id = p_id;
        this.name = name;
        Duration = duration;
        this.fee = fee;
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
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
