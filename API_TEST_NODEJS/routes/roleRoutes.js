module.exports = app => {
  const role = require("../controllers/roleController.js");

  // Create a new Customer
  app.post("/role", role.create);

  // Retrieve all role
  app.get("/role", role.findAll);

  // Retrieve a single Customer with roleId
  app.get("/role/:roleId", role.findOne);

  // Update a Customer with roleId
  app.put("/role/:roleId", role.update);

  // Delete a Customer with roleId
  app.delete("/role/:roleId", role.delete);

  // Create a new Customer
  app.delete("/role", role.deleteAll);
};