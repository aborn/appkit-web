package org.popkit.appkit.demo.mapper;

import org.popkit.appkit.demo.entity.Records;

public interface RecordsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Records
     *
     * @mbggenerated Mon Feb 26 20:30:50 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Records
     *
     * @mbggenerated Mon Feb 26 20:30:50 CST 2018
     */
    int insert(Records record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Records
     *
     * @mbggenerated Mon Feb 26 20:30:50 CST 2018
     */
    int insertSelective(Records record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Records
     *
     * @mbggenerated Mon Feb 26 20:30:50 CST 2018
     */
    Records selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Records
     *
     * @mbggenerated Mon Feb 26 20:30:50 CST 2018
     */
    int updateByPrimaryKeySelective(Records record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Records
     *
     * @mbggenerated Mon Feb 26 20:30:50 CST 2018
     */
    int updateByPrimaryKey(Records record);
}