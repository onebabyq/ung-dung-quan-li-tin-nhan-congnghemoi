module.exports = app => {
  const account = require("../controllers/accountController.js");

  // Create a new Customer
  app.post("/account", account.create);

  // Retrieve all account
  app.get("/account", account.findAll);

  // Retrieve a single Customer with accountId
  app.get("/account/:accountId", account.findOne);

  // Update a Customer with accountId
  app.put("/account/:accountId", account.update);

  // Delete a Customer with accountId
  app.delete("/account/:accountId", account.delete);

  // Create a new Customer
  app.delete("/account", account.deleteAll);
};