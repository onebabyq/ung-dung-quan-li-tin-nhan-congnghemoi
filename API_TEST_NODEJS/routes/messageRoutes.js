module.exports = app => {
  const message = require("../controllers/messageController.js");

  // Create a new Customer
  app.post("/message", message.create);

  // Retrieve all message
  app.get("/message", message.findAll);

  // Retrieve a single Customer with messageId
  app.get("/message/:messageId", message.findOne);

  // Update a Customer with messageId
  app.put("/message/:messageId", message.update);

  // Delete a Customer with messageId
  app.delete("/message/:messageId", message.delete);

  // Create a new Customer
  app.delete("/message", message.deleteAll);
};