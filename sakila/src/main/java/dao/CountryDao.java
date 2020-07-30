package dao;

import java.util.List;

import dto.CountryDTO;
import dto.CustomerDTO;
import model.Country;

public interface CountryDao {

public List<Country> findAllCountry();//1
    
    public List<Country> findById(Integer id);//2
    
    public List<Country >findByName(String countryName);//3
   
    public int  updateCountryName(Country country);//4
    
    public int deleteCountry(Country country); //5
    
    
    public List<CountryDTO> findAllInfoCountry() ; //6
    
    public int inserCountry(List<Country> country); //7
}
