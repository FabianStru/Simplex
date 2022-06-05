package de.fhws.simplex.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;

@Entity
public class ScoreMatching {
    public ScoreMatching() {

    }
    public ScoreMatching(String ip, LocalTime time) {
        this.ip = ip;
        this.time = time;
    }

    @Override
    public String toString() {
        return "ScoreMatching{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", time=" + time +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String ip;

    private LocalTime time;



    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @return the time
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @param time the time to set
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }
}
