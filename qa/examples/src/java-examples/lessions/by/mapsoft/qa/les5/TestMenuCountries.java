package by.mapsoft.qa.les5;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * Created by Alex on 25.12.2016.
 */
public class TestMenuCountries extends TestBase {
	private ArrayList<String> countriesSort,countries;
	private ArrayList<String> zonesSort,zones;
	private List<WebElement> menuCountries, menuZones;
	private WebElement rowElement, rowZones;
//	private Select combo;
	private String zonesName, countriesCode,countriesName, zonesCol;

	@Test
	public void testCountries() {

		loginLitecart();
		goMenu("Countries");
		waitPageMenu();
		countriesSort = new ArrayList<String>();
		countries = new ArrayList<String>();
		menuCountries = findRowsCountries(1);
		for (int i = 0; i < menuCountries.size(); i++) {
			rowElement = menuCountries.get(i);
			countriesName = findColCountries(rowElement).getText();
			countriesSort.add(countriesName);
			countries.add(countriesName);
		}
		countriesSort.sort(null);
		for (int i = 0; i < countries.size(); i++) {
			Assert.assertEquals(countriesSort.indexOf(countries.get(i)), i,
					"Sort failed. Country: " + countries.get(i));
			rowElement = menuCountries.get(i);
			zonesCol = findColZones(rowElement).getText();
	
			if (!zonesCol.equals("0")) {
				findColCountries(rowElement).click();
				waitPageEditCountry();
				zonesSort = new ArrayList<String>();
				zones = new ArrayList<String>();
				menuZones = findRowsZones(1);
				for (int j = 0; j < menuZones.size(); j++) {
					rowZones = menuZones.get(j);
					zonesName = findZones(rowZones).getText();
					zonesSort.add(zonesName);
					zones.add(zonesName);
				}
				zonesSort.sort(null);
				for (int j = 0; j < zones.size(); j++) {
					Assert.assertEquals(zonesSort.indexOf(zones.get(j)), j, "Sort failed. Zone: "+zones.get(j));
				}	
				goMenu("Countries");
				menuCountries = findRowsCountries(1);
				
			}

		}
	}

	@Test
	public void testZones() {

		loginLitecart();
		goMenu("Geo Zones");
		menuZones = findRowsZones(2);
		for (int i = 0; i < menuZones.size(); i++) {
			menuZones.get(i).click();
			waitPageMenu();
			countries = new ArrayList<String>();
			countriesSort = new ArrayList<String>();
			menuCountries = findRowsCountries(2);
			for (int j = 0; j < menuCountries.size(); j++) {
//				combo =  new Select(menuCountries.get(j));
//				countriesName = combo.getFirstSelectedOption().getText();
				rowElement = menuCountries.get(j);
				countriesCode = rowElement.getAttribute("value");
				countriesName = rowElement.findElement(By.xpath(".//option[@value='"+countriesCode+"']")).getText();
				countries.add(countriesName);
				countriesSort.add(countriesName);
			}
			countriesSort.sort(null);
			for (int j = 0; j < countries.size(); j++) {

				Assert.assertEquals(countriesSort.indexOf(countries.get(j)), j,
						"Sort failed. Country: " + countries.get(j));

			}
			goMenu("Geo Zones");
			menuZones = findRowsZones(2);
		}
	}
}

