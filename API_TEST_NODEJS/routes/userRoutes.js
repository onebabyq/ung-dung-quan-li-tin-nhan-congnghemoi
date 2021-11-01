module.exports = app => {
  const users = require("../controllers/userController.js");

  // Create a new Customer
  app.post("/users", users.create);

  // Retrieve all users
  app.get("/users", users.findAll);

  // Retrieve a single Customer with userId
  app.get("/users/:userId", users.findOne);

  // Update a Customer with userId
  app.put("/users/:userId", users.update);

  // Delete a Customer with userId
  app.delete("/users/:userId", users.delete);

  // Create a new Customer
  app.delete("/users", users.deleteAll);
};