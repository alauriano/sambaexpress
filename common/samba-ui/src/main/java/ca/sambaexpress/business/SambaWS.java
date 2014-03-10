package ca.sambaexpress.business;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang.Validate;

import ca.sambaexpress.business.beans.CityBean;
import ca.sambaexpress.business.beans.CountryBean;
import ca.sambaexpress.business.beans.DimensionBean;
import ca.sambaexpress.business.beans.QuotationBean;
import ca.sambaexpress.business.beans.QuotationRBean;
import ca.sambaexpress.dao.DaoException;
import ca.sambaexpress.dao.DaoFactory;
import ca.sambaexpress.dao.PricingDao;
import ca.sambaexpress.entity.City;
import ca.sambaexpress.entity.Country;
import ca.sambaexpress.entity.Pricing;

import com.google.gson.Gson;


@Path("/sambaws")
public class SambaWS {

	private static Gson gson = new Gson();
	
	@GET
	@Path("countries")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CountryBean> getCountries() {
		List<CountryBean> countries = null;
		
		try {
			List<Country> countriesEntities = DaoFactory.createCountryDao().list();
			countries = new ArrayList<CountryBean>();
			for(Country country : countriesEntities) {
				CountryBean countryBean = new CountryBean(country.getCountry_id(), country.getName());
				countries.add(countryBean);
			}
			
		} catch (DaoException e) {
			throw new WebApplicationException(e,Status.BAD_REQUEST);
		}
		return countries;
	}
	
	@GET
	@Path("cities")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CityBean> getCities(@QueryParam("countryId") int countryId) {
		Validate.notNull(countryId,"countryId:"+countryId+" is null");
		List<CityBean> citiesBean = null;
		try {
			List<City> citiesEnties = DaoFactory.createCityDao().getCityBy(countryId);
			citiesBean = new ArrayList<CityBean>();
			for(City city : citiesEnties) {
				CityBean citiBean = new CityBean(city.getCity_id(),city.getCity_description());
				citiesBean.add(citiBean);
			}
			
		} catch (DaoException e) {
			throw new WebApplicationException(e,Status.BAD_REQUEST);
		}
		
		return citiesBean;
	}
	
	@POST
	@Path("quotation")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public QuotationRBean getQuotation(String quotation) {
		QuotationRBean result = null;
		Validate.notNull(quotation);
		
		QuotationBean request = gson.fromJson(quotation, QuotationBean.class);
		Validate.notNull(request);
		PricingDao pricingDao = DaoFactory.createPricingDao();
		result = new QuotationRBean();
		try {
		for (DimensionBean d : request.getDimensions()) {
			
				List<Pricing> pricings = pricingDao.getPricing(request.getFromCityId(), request.getToCityId(), computeQuotationWeight(d) , d.getWeightUnit());
				if(pricings.size() >0 ) {
					d.setPrice(pricings.get(0).getPrice());
					d.setCurrency(pricings.get(0).getCurrency().getCurrency_code());
					d.setWeightUnit(pricings.get(0).getDimension().getWeightUnit().getWeightUnit_code());
					result.addDimensions(d);
				}
		}
		result.setFromCityName(getCityName(request.getFromCityId()));
		result.setFromCountryName(getCountryName(request.getFromCountryId()));
		result.setToCityName(getCityName(request.getToCityId()));
		result.setToCountryName(getCountryName(request.getToCountryId()));
		
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	private String getCountryName(int id) throws DaoException {
		String result = null;
		Country country = DaoFactory.createCountryDao().findById(id);
		if(country != null) {
			result = country.getName();
		}
		return result;
	}
	
	private String getCityName(int id) throws DaoException {
		String result = null;
		City city = DaoFactory.createCityDao().findById(id);
		if(city != null){
			result = city.getCity_description();
		}
		return result;
	}
	
	private float computeQuotationWeight(DimensionBean d) {
		float result = -1;
		//String dimensionUnit = d.getDimensionUnit();
		String weightUnit = d.getWeightUnit();
		
		Validate.isTrue(weightUnit != null);
		
		float length = d.getHeight();
		float width = d.getWidth();
		float height = d.getHeight();
		
		float realWeight = d.getWeight();
		Validate.isTrue(realWeight>0);
		
		Validate.isTrue(length >0 && width >0 && height >0);
		
		//weight(lbs) and dimension (pouces)
		if("lbs".equalsIgnoreCase(weightUnit.toLowerCase()) ) {
			result = Math.round(length * width*height/166);
		}
		//weight (KG) and dimension (cm)
		else if ("kgs".equalsIgnoreCase(weightUnit.toLowerCase())) {
			result = Math.round(length * width*height/6000);
		}
		
		if(realWeight >  result){
			result = realWeight;
		}
		
		Validate.notNull(d);
		return result;
	}

	
}
