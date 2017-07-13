package com.thexfactor117.losteclipse.capabilities;

/**
 * 
 * @author TheXFactor117
 *
 * Capability interface for storing player information (class, level, experience, stats, etc...)
 *
 */
public interface IPlayerInformation 
{
	int getPlayerClass();
	void setPlayerClass(int playerClass);
	
	int getPlayerLevel();
	void setPlayerLevel(int level);
	
	int getPlayerExperience();
	void setPlayerExperience(int experience);
	int getLevelUpExperience(int currentLevel); // returns the amount of experience needed to level given the current level.
	
	int getSkillPoints();
	void setSkillPoints(int skillPoints);
	
	/*
	 * Player Stats
	 */
	int getStrengthStat();
	void setStrengthStat(int stat);
	int getAgilityStat();
	void setAgilityStat(int stat);
	int getDexterityStat();
	void setDexterityStat(int stat);
	int getIntelligenceStat();
	void setIntelligenceStat(int stat);
	int getWisdomStat();
	void setWisdomStat(int stat);
	int getFortitudeStat();
	void setFortitudeStat(int stat);
	
	int getBonusStrengthStat();
	void setBonusStrengthStat(int stat);
	int getBonusAgilityStat();
	void setBonusAgilityStat(int stat);
	int getBonusDexterityStat();
	void setBonusDexterityStat(int stat);
	int getBonusIntelligenceStat();
	void setBonusIntelligenceStat(int stat);
	int getBonusWisdomStat();
	void setBonusWisdomStat(int stat);
	int getBonusFortitudeStat();
	void setBonusFortitudeStat(int stat);
	
	void removeBonusStats();
}
