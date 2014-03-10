package ca.sambaexpress.dao;

import ca.sambaexpress.entity.Pricing;

public class DaoFactory {

	private DaoFactory() {

	}

	public static PricingDao createPricingDao() {
		return new PricingDao(Pricing.class);
	}

	public static CityDao createCityDao() {
		return new CityDao();
	}

	public static CountryDao createCountryDao() {
		return new CountryDao();
	}

	public static CurrencyDao createCurrencyDao() {
		return new CurrencyDao();
	}

	public static StatusDao createStatusDao() {
		return new StatusDao();
	}

	public static TransportDao createTransportDao() {
		return new TransportDao();
	}

	public static WeightUnitDao createWeightUnitDao() {
		return new WeightUnitDao();
	}

	public static UserDao createUserDao() {
		return new UserDao();
	}

	public static SuperVisorDao createSupervisorDao() {
		return new SuperVisorDao();
	}

	public static DistributionPointDao createDistributionPoint() {
		return new DistributionPointDao();
	}

	public static CommandDao createCommandDao() {
		return new CommandDao();
	}
	
	public static ContinentDao createContinentDao(){
		return new ContinentDao();
	}
	
	public static DimensionDao createDimensionDao(){
		return new DimensionDao();
	}
	
	public static RoleDao createRoleDao() {
		return new RoleDao();
	}
}
