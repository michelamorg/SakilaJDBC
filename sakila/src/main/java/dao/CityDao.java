package dao;

import java.util.List;

import dto.CityDto;
import model.City;

public interface CityDao {

	public List<City> findAllCity();// 1

	public List<City> findById(Integer id);// 2

	public List<City> findByName(String cityName);// 3

	public int updateCityName(City city);// 4

	public int deleteCity(City city); // 5

	public List<CityDto> findAllInfoCity(); // 6

	public int insertCity(List<City> city);//7
}
