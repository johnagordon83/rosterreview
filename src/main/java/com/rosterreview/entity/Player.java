package com.rosterreview.entity;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * An {@link Entity} class defining a professional football player.
 */

@Entity
@Table(name="player")
public class Player {

    @Id
    @Column(name="id")
    protected String id;

    @Column(name="pfr_id")
    protected String pfrId;

    @Column(name="nickname")
    protected String nickname;

    @Column(name="first_name")
    protected String firstName;

    @Column(name="middle_name")
    protected String middleName;

    @Column(name="last_name")
    protected String lastName;

    @Column(name="suffix")
    protected String suffix;

    @OneToMany()
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name="player_id")
    protected Set<PlayerPosition> positions;

    @Column(name="height")
    protected Integer height;

    @Column(name="weight")
    protected Integer weight;

    @Column(name="birth_date")
    @Temporal(TemporalType.DATE)
    protected Calendar birthDate;

    @Column(name="college")
    protected String college;

    @OneToMany()
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name="player_id")
    protected Set<DraftPick> draftPicks;

    @OneToMany()
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name="player_id")
    protected List<PlayerSeason> statistics;

    @Column(name="hof_year")
    protected Integer hofYear;

    Player() {}

    public Player(String id, String pfrId, String nickname, String firstName, String middleName, String lastName,
            String suffix, Set<PlayerPosition> positions, Integer height, Integer weight, Calendar birthDate, String college,
            Set<DraftPick> draftPicks, Integer hofYear) {

        this.id = id;
        this.pfrId = pfrId;
        this.nickname = nickname;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.positions = positions;
        this.height = height;
        this.weight = weight;
        this.birthDate = birthDate;
        this.college = college;
        this.draftPicks = draftPicks;
        this.hofYear = hofYear;
    }

    /**
     * @return A unique identifier for this player.
     */
    public String getId() {
        return id;
    }

    /**
     * @param id  A unique identifier for this player.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the unique identifier used by
     * <a href="http://www.pro-football-reference.com">
     * www.pro-football-reference.com</a> for this player.
     *
     * @return The unique identifier used by PFR for this player.
     */
    public String getPfrId() {
        return pfrId;
    }

    /**
     * Sets the unique identifier used by
     * <a href="http://www.pro-football-reference.com">
     * www.pro-football-reference.com</a> for this player.
     *
     * @param pfrId  A unique identifier used by PFR for this player.
     */
    public void setPfrId(String pfrId) {
        this.pfrId = pfrId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * @return The positions the player is most known for playing.
     */
    public Set<PlayerPosition> getPositions() {
        return positions;
    }

    /**
     * @param positions  The positions the player is most known for playing.
     */
    public void setPositions(Set<PlayerPosition> positions) {
        this.positions = positions;
    }

    /**
     * @return The player's height (in).
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * @param height  The player's height (in).
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * @return The player's weight (lb).
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * @param weight  The player's weight (lb).
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    /**
     * @return A set of {@link DraftPick DraftPick(s)} that describe the player's draft history.
     */
    public Set<DraftPick> getDraftPicks() {
        return draftPicks;
    }

    /**
     * @param draftPicks  A set of {@link DraftPick DraftPick(s)} that describe the player's
     *                    draft history.
     */
    public void setDraftPicks(Set<DraftPick> draftPicks) {
        this.draftPicks = draftPicks;
    }

    /**
     * @return A list of {@link PlayerSeason PlayerSeason(s)} that contain the player's statistics
     *         for each year of their career.
     */
    public List<PlayerSeason> getStatistics() {
        return statistics;
    }

    /**
     * @param statistics  A list of {@link PlayerSeason PlayerSeason(s)} that contain the player's
     *        statistics for each year of their career.
     */
    public void setStatistics(List<PlayerSeason> statistics) {
        this.statistics = statistics;
    }

    /**
     * @return The year the player was inducted into the Pro Football Hall of Fame.
     */
    public Integer getHofYear() {
        return hofYear;
    }

    /**
     * @param hofYear  The year the player was inducted into the Pro Football Hall of Fame.
     */
    public void setHofYear(Integer hofYear) {
        this.hofYear = hofYear;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, new RecursiveToStringStyle());
    }
}