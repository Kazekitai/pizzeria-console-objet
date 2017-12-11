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

/**
 *Dao Class to manipulate data from database
 * 
 * @author Sandra Le Thiec
 *
 */
public class PizzaDaoJdbc implements IPizzaDao {
	/* ATTRIBUTES */
	private final Logger LOGGER = LoggerFactory.getLogger("logger2");

	/* CONSTRUCTOR */
	/**
	 * Constructor PizzaDaoJdbc
	 */
	public PizzaDaoJdbc() {
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
		} finally {
			if (resultats != null) {
				try {
					resultats.close();
				} catch (SQLException e) {
					LOGGER.error(e.getMessage());
					throw new StopApplicationException(e.getMessage());
				}
			}
			if (selectPizzaSt != null) {
				try {
					selectPizzaSt.close();
				} catch (SQLException e) {
					LOGGER.error(e.getMessage());
					throw new StopApplicationException(e.getMessage());
				}
			}
			if (DbManager.getInstance().getConnection() != null) {
				try {
					DbManager.getInstance().getConnection().close();
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
		PreparedStatement prepStat = null;
		int resultat = 0;
		try {
			if (doesPizzaExist(pizza.getCode()) == false) {
				DbManager.getInstance().openDbConnection();
				String insertQuery = "INSERT INTO pizza (CODE,NOM,CATEGORIE,PRIX) VALUES(?,?,?,?)";
				prepStat = DbManager.getInstance().getConnection().prepareStatement(insertQuery);
				prepStat.setString(1, pizza.getCode());
				prepStat.setString(2, pizza.getNom());
				prepStat.setString(3, pizza.getCategoriePizza().getValue());
				prepStat.setDouble(4, pizza.getPrix());
				resultat = prepStat.executeUpdate();

				prepStat.close();
				DbManager.getInstance().getConnection().close();
			} else {
				LOGGER.error("La pizza est déjà présente dans la base");
			}
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (prepStat != null) {
				try {
					prepStat.close();
				} catch (SQLException e) {
					LOGGER.error(e.getMessage());
					throw new StopApplicationException(e.getMessage());
				}
			}
			if (DbManager.getInstance().getConnection() != null) {
				try {
					DbManager.getInstance().getConnection().close();
				} catch (SQLException e) {
					LOGGER.error(e.getMessage());
					throw new StopApplicationException(e.getMessage());
				}
			}

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
		PreparedStatement prepStat = null;
		int resultat = 0;
		try {
			if (doesPizzaExist(codePizza) == true) {
				DbManager.getInstance().openDbConnection();
				String updateQuery = "UPDATE pizza SET CODE=?, NOM=?, CATEGORIE=?, PRIX=? WHERE CODE=?";
				prepStat = DbManager.getInstance().getConnection().prepareStatement(updateQuery);
				prepStat.setString(1, pizza.getCode());
				prepStat.setString(2, pizza.getNom());
				prepStat.setString(3, pizza.getCategoriePizza().getValue());
				prepStat.setDouble(4, pizza.getPrix());
				prepStat.setString(5, codePizza);
				resultat = prepStat.executeUpdate();

				prepStat.close();
				DbManager.getInstance().getConnection().close();
			} else {
				LOGGER.error("La pizza n'est pas présente dans la base");
			}
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (prepStat != null) {
				try {
					prepStat.close();
				} catch (SQLException e) {
					LOGGER.error(e.getMessage());
					throw new StopApplicationException(e.getMessage());
				}
			}
			if (DbManager.getInstance().getConnection() != null) {
				try {
					DbManager.getInstance().getConnection().close();
				} catch (SQLException e) {
					LOGGER.error(e.getMessage());
					throw new StopApplicationException(e.getMessage());
				}
			}

		}
		return false;
	}

	/**
	 * Delete pizza into table by pizza code
	 * 
	 * @param codePizza
	 */
	@Override
	public boolean deletePizza(String codePizza) {
		PreparedStatement prepStat = null;
		int resultat = 0;
		try {
			if (doesPizzaExist(codePizza) == true) {
				DbManager.getInstance().openDbConnection();
				String deleteQuery = "DELETE FROM pizza WHERE CODE=?";
				prepStat = DbManager.getInstance().getConnection().prepareStatement(deleteQuery);
				prepStat.setString(1, codePizza);
				resultat = prepStat.executeUpdate();
				prepStat.close();
				DbManager.getInstance().getConnection().close();
			} else {
				LOGGER.error("La pizza n'est pas présente dans la base");
			}
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (prepStat != null) {
				try {
					prepStat.close();
				} catch (SQLException e) {
					LOGGER.error(e.getMessage());
					throw new StopApplicationException(e.getMessage());
				}
			}
			if (resultat != 0) {
				try {
					DbManager.getInstance().getConnection().close();
				} catch (SQLException e) {
					LOGGER.error(e.getMessage());
					throw new StopApplicationException(e.getMessage());
				}
			}
		}
		return false;
	}

	/**
	 * Test if pizza exist
	 * 
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
