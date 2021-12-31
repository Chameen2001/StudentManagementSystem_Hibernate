package embeded;

import javax.persistence.Embeddable;

@Embeddable
public class Name {
    String f_name;
    String l_name;
    String m_name;

    public Name() {
    }

    public Name(String f_name, String l_name, String m_name) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.m_name = m_name;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    @Override
    public String toString() {
        return "Name{" +
                "f_name='" + f_name + '\'' +
                ", l_name='" + l_name + '\'' +
                ", m_name='" + m_name + '\'' +
                '}';
    }
}
