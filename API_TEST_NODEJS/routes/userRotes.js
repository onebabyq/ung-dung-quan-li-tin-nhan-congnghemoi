module.exports = app => {
  const users = require("../controllers/userController.js");

  // Create a new Customer
  app.post("/users", users.create);

  // Retrieve all users
  app.get("/users", users.findAll);

  // Retrieve a single Customer with customerId
  app.get("/users/:customerId", users.findOne);

  // Update a Customer with customerId
  app.put("/users/:customerId", users.update);

  // Delete a Customer with customerId
  app.delete("/users/:customerId", users.delete);

  // Create a new Customer
  app.delete("/users", users.deleteAll);
};