package fr.pizzeria.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.runtime.StopApplicationException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJdbc implements IPizzaDao {
	/* ATTRIBUTES */
	private final Logger LOGGER = LoggerFactory.getLogger("logger2"); 

	/* CONSTRUCTOR */
	/**
	 * Constructor PizzaDaoJdbc
	 */
	public PizzaDaoJdbc() {
		/* Initialization of pizza list */
		// this.saveNewPizza(new Pizza("PEP","Pépéroni","VIANDE",12.50));
		// this.saveNewPizza(new Pizza("MAR","Margherita","SANS_VIANDE",14.00));
		// this.saveNewPizza(new Pizza("REI","La Reine","SANS_VIANDE",11.50));
		// this.saveNewPizza(new Pizza("FRO","La 4 fromage","VIANDE",12.50));
		// this.saveNewPizza(new Pizza("CAN","La Cannibale","VIANDE",12.50));
		// this.saveNewPizza(new Pizza("SAV","La Savoyarde","VIANDE",13.00));
		// this.saveNewPizza(new Pizza("ORI","L'Orientale","VIANDE",13.50));
		// this.saveNewPizza(new Pizza("IND","L'Indienne","VIANDE",14.00));
	}

	/* METHODS */

	
	/**
	 * Find all pizza
	 */
	@Override
	public ArrayList<Pizza> findAllPizza() {
		ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
		ResultSet resultats = null;
		PreparedStatement selectPizzaSt = null;
		try {
			DbManager.getInstance().openDbConnection();
			String selectQuery = "SELECT * FROM pizza";
			selectPizzaSt = DbManager.getInstance().getConnection().prepareStatement(selectQuery);
			resultats = selectPizzaSt.executeQuery();
			while (resultats.next()) {
				Pizza pizza = new Pizza(resultats.getString("CODE"), resultats.getString("NOM"),
						resultats.getString("CATEGORIE"), resultats.getDouble("PRIX"));
				pizza.setId(resultats.getInt("ID"));
				pizzas.add(pizza);
			}
			selectPizzaSt.close();
			DbManager.getInstance().getConnection().close();
			return pizzas;
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			throw new StopApplicationException(e.getMessage());
		}
		finally {
			if(resultats != null) {
				try {
					DbManager.getInstance().getConnection().close();
				} catch (SQLException e) {
					LOGGER.error(e.getMessage());
					throw new StopApplicationException(e.getMessage());
				}
			}
			if(selectPizzaSt != null) {
				try {
					selectPizzaSt.close();
				} catch (SQLException e) {
					LOGGER.error(e.getMessage());
					throw new StopApplicationException(e.getMessage());
				}
			}
		}
	}

	/**
	 * Add and save new pizza to table
	 * 
	 * @param pizza
	 */
	@Override
	public boolean saveNewPizza(Pizza pizza) {
		try {
			if (doesPizzaExist(pizza.getCode()) == false) {
				DbManager.getInstance().openDbConnection();
				String insertQuery = "INSERT INTO pizza (CODE,NOM,CATEGORIE,PRIX) VALUES(?,?,?,?)";
				PreparedStatement prepStat = DbManager.getInstance().getConnection().prepareStatement(insertQuery);
				prepStat.setString(1, pizza.getCode());
				prepStat.setString(2, pizza.getNom());
				prepStat.setString(3, pizza.getCategoriePizza().getValue());
				prepStat.setDouble(4, pizza.getPrix());
				prepStat.executeUpdate();

				prepStat.close();
				DbManager.getInstance().getConnection().close();
			} else {
				LOGGER.error("La pizza est déjà présente dans la base");
			}
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Update a pizza into table by pizza code
	 * 
	 * @param codePizza
	 * @param pizza
	 */
	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		try {
			if (doesPizzaExist(codePizza) == true) {
				DbManager.getInstance().openDbConnection();
				String updateQuery = "UPDATE pizza SET CODE=?, NOM=?, CATEGORIE=?, PRIX=? WHERE CODE=?";
				PreparedStatement prepStat = DbManager.getInstance().getConnection().prepareStatement(updateQuery);
				prepStat.setString(1, pizza.getCode());
				prepStat.setString(2, pizza.getNom());
				prepStat.setString(3, pizza.getCategoriePizza().getValue());
				prepStat.setDouble(4, pizza.getPrix());
				prepStat.setString(5, codePizza);
				prepStat.executeUpdate();

				prepStat.close();
				DbManager.getInstance().getConnection().close();
			} else {
				LOGGER.error("La pizza n'est pas présente dans la base");
			}
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Delete pizza into table by pizza code
	 * @param codePizza
	 */
	@Override
	public boolean deletePizza(String codePizza) {
		try {
			if (doesPizzaExist(codePizza) == true) {
				DbManager.getInstance().openDbConnection();
				String deleteQuery = "DELETE FROM pizza WHERE CODE=?";
				PreparedStatement prepStat = DbManager.getInstance().getConnection().prepareStatement(deleteQuery);
				prepStat.setString(1, codePizza);
				prepStat.executeUpdate();

				prepStat.close();
				DbManager.getInstance().getConnection().close();
			} else {
				LOGGER.error("La pizza n'est pas présente dans la base");
			}
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	/**
	 * Test if pizza exist
	 * @param codePizza
	 * @return
	 */
	public boolean doesPizzaExist(String codePizza) {
		try {
			DbManager.getInstance().openDbConnection();
			String selectQuery = "SELECT * FROM pizza";
			PreparedStatement selectPizzaSt = DbManager.getInstance().getConnection().prepareStatement(selectQuery);
			ResultSet resultats = selectPizzaSt.executeQuery();
			while (resultats.next()) {
				if (resultats.getString("CODE").equals(codePizza)) {
					return true;
				}
			}
			selectPizzaSt.close();
			DbManager.getInstance().getConnection().close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
