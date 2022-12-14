package com.song.work.dao.mapper;

import com.song.work.model.Favorites;
import com.song.work.model.FavoritesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FavoritesMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table favorites
	 * @mbggenerated  Wed Mar 22 08:54:53 CST 2017
	 */
	int countByExample(FavoritesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table favorites
	 * @mbggenerated  Wed Mar 22 08:54:53 CST 2017
	 */
	int deleteByExample(FavoritesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table favorites
	 * @mbggenerated  Wed Mar 22 08:54:53 CST 2017
	 */
	int deleteByPrimaryKey(Integer fid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table favorites
	 * @mbggenerated  Wed Mar 22 08:54:53 CST 2017
	 */
	int insert(Favorites record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table favorites
	 * @mbggenerated  Wed Mar 22 08:54:53 CST 2017
	 */
	int insertSelective(Favorites record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table favorites
	 * @mbggenerated  Wed Mar 22 08:54:53 CST 2017
	 */
	List<Favorites> selectByExample(FavoritesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table favorites
	 * @mbggenerated  Wed Mar 22 08:54:53 CST 2017
	 */
	Favorites selectByPrimaryKey(Integer fid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table favorites
	 * @mbggenerated  Wed Mar 22 08:54:53 CST 2017
	 */
	int updateByExampleSelective(@Param("record") Favorites record, @Param("example") FavoritesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table favorites
	 * @mbggenerated  Wed Mar 22 08:54:53 CST 2017
	 */
	int updateByExample(@Param("record") Favorites record, @Param("example") FavoritesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table favorites
	 * @mbggenerated  Wed Mar 22 08:54:53 CST 2017
	 */
	int updateByPrimaryKeySelective(Favorites record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table favorites
	 * @mbggenerated  Wed Mar 22 08:54:53 CST 2017
	 */
	int updateByPrimaryKey(Favorites record);
}